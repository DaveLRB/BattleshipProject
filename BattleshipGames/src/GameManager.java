import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

class GameManager {
    protected static final String BOMB_SYMBOL = "💥";
    protected static final String MISS_SYMBOL = "𝐗";
    public void placeShipsManually(Player player) {
        player.createBattleshipBoard();
        placeShip(player, new AircraftCarrier(), "Please, place the Carrier / it occupies 6 coordinates");
        placeShip(player, new Battleship(), "Please, place the Battleship/ it occupies 5 coordinates");
        placeShip(player, new Submarine(), "Please, place the Submarine / it occupies 4 coordinates");
        placeShip(player, new Corvette(), "Please, place the Corvette / it occupies 4 coordinates");
        placeShip(player, new Cruiser(), "Please, place the Cruiser / it occupies 3 coordinates");
        placeShip(player, new Destroyer(), "Please, place the Destroyer / it occupies 2 coordinates");
        player.displayBattleshipBoard();
        player.createBattleshipBoard();
    }

    public void placeShipsRandomly(Player player) {
        player.createBattleshipBoard();
        placeShipRandomly(player, new AircraftCarrier());
        placeShipRandomly(player, new Battleship());
        placeShipRandomly(player, new Submarine());
        placeShipRandomly(player, new Corvette());
        placeShipRandomly(player, new Cruiser());
        placeShipRandomly(player, new Destroyer());
        player.displayBattleshipBoard();
        player.createBattleshipBoard();
    }

    public void playerShootsMissile(Player player, String[][] boardgame, String numberOfPlayer){
        boolean isThereShip;
        do{
            isThereShip=false;
            System.out.println("It's time for Player "+ numberOfPlayer + " to play");
            if(player.isAnyShipSunk()){
                System.out.println("The "+ player.getNameOfSunkShip()+ " was sunk");
            }
            player.displayBattleshipBoard();
            Coordinate userCoordinate = InputHandler.getCoordinate();;
            for(int i=0; i<player.getShips().size();i++){
                ArrayList<Coordinate> shipCoordinates = player.getShips().get(i).coordinates;
                for(int i1=0; i1<player.getShips().get(i).getCoordinates().size();i1++){
                    if(player.getShips().get(i).getCoordinates().get(i1).toString().equals(userCoordinate.toString())){
                        player.getShips().get(i).getCoordinates().remove(player.getShips().get(i).getCoordinates().get(i1));
                        boardgame[userCoordinate.getRow()][userCoordinate.getColumn()]=BOMB_SYMBOL;
                        isThereShip=true;
                        break;
                    }
                }
            }
            //problems with player.isAnyShipsSunk/ it isn't properly removing the ships and coordinates
            if(!isThereShip){
                boardgame[userCoordinate.getRow()][userCoordinate.getColumn()] = MISS_SYMBOL ;
            }
            player.displayBattleshipBoard();
        }while(isThereShip && !player.isGameOver());
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
            isPlacementValid = direction.equals("H")
                    ? ship.isPlacingShipHorizontallyPossible(player.getBoard(), coordinate)
                    : ship.isPlacingShipVerticallyPossible(player.getBoard(), coordinate);
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
        String direction = (random.nextInt(3) == 1) ? "H" : "V";
        boolean isPlacementValid;
        do {
            Coordinate coordinate = new Coordinate(random.nextInt(10), random.nextInt(10));
            isPlacementValid = direction.equals("H")
                    ? ship.isPlacingShipHorizontallyPossible(player.getBoard(), coordinate)
                    : ship.isPlacingShipVerticallyPossible(player.getBoard(), coordinate);
            if (isPlacementValid) placeShipOnBoard(direction, ship, player, coordinate);
        } while (!isPlacementValid);
    }
}
