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
        placeBattleship(player1, player1Battleship);

    }

    private void placeBattleshipOnBoard(String direction, Ship ship, Player player, Coordinate coordinate) {
        if (direction.equals("H")) {
            ship.placeShipHorizontally(player.getBoardGame(), coordinate);
        } else {
            ship.placeShipVertically(player.getBoardGame(), coordinate);
        }
    }

    private void placeBattleship(Player player, Ship ship) {
        //player.createBattleshipBoard(); test this outside, in order to see if it works
        player.displayBattleshipBoard();
        System.out.println();
        System.out.println("Please, place the Battleship/ it occupies 5 coordinates");
        Coordinate coordinate;
        boolean isPlacementValid = false;
        do {
            String direction = InputHandler.getDirectionHorizontalOrVerticalInput();
            String userCoordinate = InputHandler.getCoordinateInput();
            coordinate = InputHandler.createCoordinate(userCoordinate);
            System.out.println(coordinate);
            System.out.println();
            if (direction.equals("H")) {
                isPlacementValid = ship.isPlacingShipHorizontallyPossible(player.getBoardGame(), coordinate);
            } else {
                isPlacementValid = ship.isPlacingShipVerticallyPossible(player.getBoardGame(), coordinate);
            }
            if (isPlacementValid) {
                placeBattleshipOnBoard(direction, ship, player, coordinate);
            } else {
                System.out.println("error, invalid coordinate\n");
            }
        } while (!isPlacementValid);
        player1.displayBattleshipBoard();

    }
}
