import java.util.ArrayList;
import java.util.Arrays;

class Player {
    private final int SIZE_OF_ROWS_AND_COLUMNS= 10;
    private String[][] board = new String[SIZE_OF_ROWS_AND_COLUMNS][SIZE_OF_ROWS_AND_COLUMNS];
    ArrayList<Ship> ships = new ArrayList<>();

    public void createBattleshipBoard() {
        for(String[] symbol : board){
            Arrays.fill(symbol,"🌊");
        }
    }

    public void displayBattleshipBoard() {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.print("\t");
        for (int i = 0; i < SIZE_OF_ROWS_AND_COLUMNS; i++) {
            System.out.print(i + 1 + "\t");
        }
        System.out.println();

        for (int row = 0; row < SIZE_OF_ROWS_AND_COLUMNS; row++) {
            System.out.print(letters[row]);
            System.out.print("\t");
            for (int col = 0; col < SIZE_OF_ROWS_AND_COLUMNS; col++) {
                System.out.print(board[row][col] + "\t");
            }
            System.out.println();
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void addShip(Ship ship){
        ships.add(ship);
    }
}
