import java.util.Scanner;
import java.util.Random;

class GameManager {
    public GameManager() {}

    public void startPlayerVsPlayerGame() {
        //player1.createBattleshipBoard(); //test
        //placeShipManuallyPlayer(player1);
        //placeShipRandomly(player1, new Battleship());
    }

    public void placeShipsManually(Player player){
        player.createBattleshipBoard();
        placeShip(player, new AircraftCarrier(), "Please, place the Carrier / it occupies 6 coordinates");
        placeShip(player, new Battleship(), "Please, place the Battleship/ it occupies 5 coordinates");
        placeShip(player, new Submarine(), "Please, place the Submarine / it occupies 4 coordinates");
        placeShip(player, new Corvette(), "Please, place the Corvette / it occupies 4 coordinates");
        placeShip(player, new Cruiser(), "Please, place the Cruiser / it occupies 3 coordinates");
        placeShip(player, new Destroyer(), "Please, place the Destroyer / it occupies 2 coordinates");
        player.displayBattleshipBoard();
    }

    public void placeShipsRandomly(Player player){
        player.createBattleshipBoard();
        placeShipRandomly(player, new AircraftCarrier());
        placeShipRandomly(player, new Battleship());
        placeShipRandomly(player, new Submarine());
        placeShipRandomly(player, new Corvette());
        placeShipRandomly(player, new Cruiser());
        placeShipRandomly(player, new Destroyer());
        player.displayBattleshipBoard();
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

    private void placeShipRandomly(Player player, Ship ship) {
        Random random = new Random();
        int directionInt = random.nextInt(3);
        String direction;
        if(directionInt==1){
            direction="H";
        }else{
            direction="V";
        }
        boolean isPlacementValid;
        do{
            int row = random.nextInt(10);
            int column = random.nextInt(10);
            Coordinate coordinate = new Coordinate(row,column);
            if(direction.equals("H")){
                isPlacementValid = ship.isPlacingShipHorizontallyPossible(player.getBoard(), coordinate);
            }else{
                isPlacementValid = ship.isPlacingShipVerticallyPossible(player.getBoard(), coordinate);
            }
            if(isPlacementValid){
                placeShipOnBoard(direction, ship, player, coordinate);
            }
        }while(!isPlacementValid);
    }
}
