import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

class GameManager {
    protected static final String BOMB_SYMBOL = "💥";
    protected static final String MISS_SYMBOL = "❌";

    public void placeShipsManually(Player player) {
        player.createBattleshipBoard();
        placeShip(player, new AircraftCarrier(), Colors.BRIGHT_CYAN + "Please, place the Carrier / occupies 6 coordinates" + Colors.RESET);
        placeShip(player, new Battleship(), Colors.BRIGHT_CYAN + "Please, place the Battleship/ occupies 5 coordinates" + Colors.RESET);
        placeShip(player, new Submarine(), Colors.BRIGHT_CYAN + "Please, place the Submarine / occupies 4 coordinates" + Colors.RESET);
        placeShip(player, new Corvette(), Colors.BRIGHT_CYAN + "Please, place the Corvette / occupies 4 coordinates" + Colors.RESET);
        placeShip(player, new Cruiser(), Colors.BRIGHT_CYAN + "Please, place the Cruiser / occupies 3 coordinates" + Colors.RESET);
        placeShip(player, new Destroyer(), Colors.BRIGHT_CYAN + "Please, place the Destroyer / occupies 2 coordinates" + Colors.RESET);
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

    public void playerShootsMissile(Player player, String[][] boardgame, String numberOfPlayer) {
        boolean isThereShip=false;
        String nameOfTheSunkShip = "";
        boolean isAnyShipSunk = false;
        do {
            System.out.println();
            System.out.println(Colors.BRIGHT_CYAN + "Player " + numberOfPlayer + " plays" + Colors.RESET);
            System.out.println();
            System.out.println(Colors.BRIGHT_YELLOW + "Ships left: "+ player.getShips().size() + Colors.RESET);
            System.out.println();
            if(isThereShip){
                System.out.println(Colors.BRIGHT_GREEN + "\n" +
                        "╔═╗┬ ┬┌─┐┌┬┐  ╦ ╦┬┌┬┐\n" +
                        "╚═╗├─┤│ │ │   ╠═╣│ │ \n" +
                        "╚═╝┴ ┴└─┘ ┴   ╩ ╩┴ ┴ \n" + Colors.RESET);
            }
            isThereShip = false;
            if (isAnyShipSunk) {
                System.out.println("⚓️" + Colors.CYAN + " The " + nameOfTheSunkShip + " was sunk " + Colors.RESET + " ⚓️");
                System.out.println();
            }
            isAnyShipSunk = false;
            player.displayBattleshipBoard();
            Coordinate userCoordinate = InputHandler.getCoordinate(player);
            ;
            for (int i = 0; i < player.getShips().size(); i++) {
                //ArrayList<Coordinate> shipCoordinates = player.getShips().get(i).coordinates;
                for (int i1 = 0; i1 < player.getShips().get(i).getCoordinates().size(); i1++) {
                    if (player.getShips().get(i).getCoordinates().get(i1).toString().equals(userCoordinate.toString())) {
                        player.getShips().get(i).getCoordinates().remove(player.getShips().get(i).getCoordinates().get(i1));
                        boardgame[userCoordinate.getRow()][userCoordinate.getColumn()] = BOMB_SYMBOL;
                        isThereShip = true;
                        break;
                    }
                }
            }
            if (player.isAnyShipSunk()) {
                isAnyShipSunk = true;
                nameOfTheSunkShip = player.getNameOfSunkShip();
                player.removeSunkShip();
            }
            //problems with player.isAnyShipsSunk/ it isn't properly removing the ships and coordinates
            //get the name of the ship before eliminating it RIGHT HERE.
            //I need to eliminate the ship at the right time and keep the name

            if (!isThereShip) {
                boardgame[userCoordinate.getRow()][userCoordinate.getColumn()] = MISS_SYMBOL;
            }
            if (!isThereShip) {
                System.out.println(Colors.BRIGHT_RED + "\n" +
                        "╔╦╗┬┌─┐┌─┐┌─┐┌┬┐  ┌─┐┬ ┬┌─┐┌┬┐\n" +
                        "║║║│└─┐└─┐├┤  ││  └─┐├─┤│ │ │ \n" +
                        "╩ ╩┴└─┘└─┘└─┘─┴┘  └─┘┴ ┴└─┘ ┴ \n" + Colors.RESET);
                player.displayBattleshipBoard();
            }
        } while (isThereShip && !player.isGameOver());
    }

    private void placeShipOnBoard(String direction, Ship ship, Player player, Coordinate coordinate) {
        if (direction.equals("H")) {
            ship.placeShipHorizontally(player.getBoard(), coordinate);
            player.addShip(ship);
            //System.out.println(ship.getCoordinates());
        } else {
            ship.placeShipVertically(player.getBoard(), coordinate);
            player.addShip(ship);
            //System.out.println(ship.getCoordinates());
        }
    }

    public void placeShipOnBoard(Ship ship, Player player, Coordinate coordinate){
        ship.placeShipHorizontally(player.getBoard(), coordinate);
    }

    private void placeShip(Player player, Ship ship, String title) {
        //player.createBattleshipBoard(); test this outside, in order to see if it works
        System.out.println();
        player.displayBattleshipBoard();
        System.out.println();
        System.out.println(title);
        Coordinate coordinate;
        boolean isPlacementValid = false;
        do {
            String direction = InputHandler.getDirectionHorizontalOrVerticalInput();
            String userCoordinate = InputHandler.getCoordinateInput();
            coordinate = InputHandler.createCoordinate(userCoordinate);
            //System.out.println(coordinate);
            System.out.println();
            isPlacementValid = direction.equals("H")
                    ? ship.isPlacingShipHorizontallyPossible(player.getBoard(), coordinate)
                    : ship.isPlacingShipVerticallyPossible(player.getBoard(), coordinate);
            if (isPlacementValid) {
                placeShipOnBoard(direction, ship, player, coordinate);
            } else {
                System.out.println(Colors.RED + "Error, Invalid Coordinate\n" + Colors.RESET);
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
