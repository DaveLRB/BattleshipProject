public class Player {
    private final int sizeOfRowsAndColumns = 10;
    private String[][] boardGame = new String[sizeOfRowsAndColumns][sizeOfRowsAndColumns];

    public void createBattleshipBoard() {
        for (int row = 0; row < sizeOfRowsAndColumns; row++) {
            for (int col = 0; col < sizeOfRowsAndColumns; col++) {
                boardGame[row][col] = "🌊";
            }
        }

    }

    public void displayBattleshipBoard() {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.print("\t");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + 1 + "\t");
        }
        System.out.println();

        for (int row = 0; row < sizeOfRowsAndColumns; row++) {
            System.out.print(letters[row]);
            System.out.print("\t");
            for (int col = 0; col < sizeOfRowsAndColumns; col++) {
                System.out.print(boardGame[row][col] + "\t");
            }
            System.out.println();
        }
    }

    public String[][] getBoardGame() {
        return boardGame;
    }

    /*public void placeBattleshipHorizontally(Coordinate coordinate, Battleship battleship) {
        Battleship.placeShipHorizontally(boardGame, coordinate);
    }

    public void placeBattleshipVertically(Coordinate coordinate) {
        Battleship.placeShipVertically(boardGame, coordinate);
    }

    public boolean isPlacingBattleshipHorizontallyPossible(Coordinate coordinate) {
        if (Battleship.isPlacingShipHorizontallyPossible(boardGame, coordinate)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPlacingBattleshipVerticallyPossible(Coordinate coordinate) {
        if (Battleship.isPlacingShipVerticallyPossible(boardGame, coordinate)) {
            return true;
        } else {
            return false;
        }
    }*/
}
