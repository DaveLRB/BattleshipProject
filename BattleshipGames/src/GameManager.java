import java.util.Scanner;

class GameManager {
    private Player player1;

    public GameManager() {
        this.player1 = new Player();
    }

    public void startPlayerVsPlayerGame() {
        player1.createBattleshipBoard(); //test
        placeShip(player1, new AircraftCarrier(), "Please, place the Carrier / it occupies 6 coordinates");
        placeShip(player1, new Battleship(), "Please, place the Battleship/ it occupies 5 coordinates");
        placeShip(player1, new Submarine(), "Please, place the Submarine / it occupies 4 coordinates");
        placeShip(player1, new Corvette(), "Please, place the Corvette / it occupies 4 coordinates");
        placeShip(player1, new Cruiser(), "Please, place the Cruiser / it occupies 3 coordinates");
        placeShip(player1, new Destroyer(), "Please, place the Destroyer / it occupies 2 coordinates");
        player1.displayBattleshipBoard();
    }

    private void placeShipOnBoard(String direction, Ship ship, Player player, Coordinate coordinate) {
        if (direction.equals("H")) {
            ship.placeShipHorizontally(player.getBoard(), coordinate);
            player.addShip(ship);
            System.out.println(ship.getCoordinates());
        } else {
            ship.placeShipVertically(player.getBoard(), coordinate);
            player.addShip(ship);
            System.out.println(ship.getCoordinates());
        }
    }

    private void placeShip(Player player, Ship ship, String title) {
        //player.createBattleshipBoard(); test this outside, in order to see if it works
        player.displayBattleshipBoard();
        System.out.println();
        System.out.println(title);
        Coordinate coordinate;
        boolean isPlacementValid = false;
        do {
            String direction = InputHandler.getDirectionHorizontalOrVerticalInput();
            String userCoordinate = InputHandler.getCoordinateInput();
            coordinate = InputHandler.createCoordinate(userCoordinate);
            System.out.println(coordinate);
            System.out.println();
            if (direction.equals("H")) {
                isPlacementValid = ship.isPlacingShipHorizontallyPossible(player.getBoard(), coordinate);
            } else {
                isPlacementValid = ship.isPlacingShipVerticallyPossible(player.getBoard(), coordinate);
            }
            if (isPlacementValid) {
                placeShipOnBoard(direction, ship, player, coordinate);
            } else {
                System.out.println("error, invalid coordinate\n");
            }
        } while (!isPlacementValid);
        //player1.displayBattleshipBoard();

    }
}
