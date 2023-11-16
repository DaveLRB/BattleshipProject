import java.util.Scanner;

class GameManager {
    private Player player1;
    private Battleship player1Battleship;

    public GameManager() {
        this.player1 = new Player();
        this.player1Battleship = new Battleship();
    }

    public void startPlayerVsPlayerGame() {
        player1.createBattleshipBoard(); //test
        placeShip(player1, player1Battleship, "Please, place the Battleship/ it occupies 5 coordinates");

    }

    private void placeShipOnBoard(String direction, Ship ship, Player player, Coordinate coordinate) {
        if (direction.equals("H")) {
            ship.placeShipHorizontally(player.getBoard(), coordinate);
        } else {
            ship.placeShipVertically(player.getBoard(), coordinate);
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
        player1.displayBattleshipBoard();

    }
}
