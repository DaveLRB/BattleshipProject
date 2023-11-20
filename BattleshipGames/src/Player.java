import java.util.ArrayList;
import java.util.Arrays;

class Player {
    private final int SIZE_OF_ROWS_AND_COLUMNS = 10;
    private String[][] board = new String[SIZE_OF_ROWS_AND_COLUMNS][SIZE_OF_ROWS_AND_COLUMNS];
    private ArrayList<Ship> ships = new ArrayList<>();

    public void createBattleshipBoard() {
        for (String[] symbol : board) {
            Arrays.fill(symbol, "🌊");
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

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public boolean isAnyShipSunk() {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).getCoordinates().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public String getNameOfSunkShip() {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).getCoordinates().isEmpty()) {
                String nameOfTheShip = ships.get(i).getShipName();
                return nameOfTheShip;
            }
        }
        return "";
    }

    public void removeSunkShip() {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).getCoordinates().isEmpty()) {
                this.getShips().remove(this.getShips().get(i));
            }
        }
    }

    public boolean isGameOver() {
        if (ships.isEmpty()) {
            return true;
        }
        return false;
    }
}
