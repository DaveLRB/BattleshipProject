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

    private static void placeBattleshipOnBoard(String direction, Battleship battleship, Player player, Coordinate coordinate) {
        if (direction.equals("H")) {
            battleship.placeShipHorizontally(player.getBoardGame(), coordinate);
        } else {
            battleship.placeShipVertically(player.getBoardGame(), coordinate);
        }
    }

    private void placeBattleship(Player player, Battleship battleship) {
        //player.createBattleshipBoard(); test this outside, in order to see if it works
        player.displayBattleshipBoard();
        System.out.println();
        System.out.println("Please, place the Battleship/ it occupies 5 coordinates");
        Coordinate coordinate;
        boolean isPlacementValid = false;
        do {
            String direction = InputValidator.getDirectionHorizontalOrVerticalInput();
            String userCoordinate = InputValidator.getCoordinateInput();
            coordinate = InputValidator.createCoordinate(userCoordinate);
            System.out.println(coordinate);
            System.out.println();
            if (direction.equals("H")) {
                isPlacementValid = battleship.isPlacingShipHorizontallyPossible(player.getBoardGame(), coordinate);
            } else {
                isPlacementValid = battleship.isPlacingShipVerticallyPossible(player.getBoardGame(), coordinate);
            }
            if (isPlacementValid) {
                placeBattleshipOnBoard(direction, battleship, player, coordinate);
            } else {
                System.out.println("error, invalid coordinate\n");
            }
        } while (!isPlacementValid);
        player1.displayBattleshipBoard();
    }
}
