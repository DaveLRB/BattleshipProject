public class Battleship {

    public static void shootMissile() {

    }

    public void placeShipHorizontally(String[][] boardgame, Coordinate coordinate) {
        boardgame[coordinate.getRow()][coordinate.getColumn()] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️");
        boardgame[coordinate.getRow()][coordinate.getColumn() - 1] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "️️⚓️");
        boardgame[coordinate.getRow()][coordinate.getColumn() - 2] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️");
        boardgame[coordinate.getRow()][coordinate.getColumn() + 1] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️");
        boardgame[coordinate.getRow()][coordinate.getColumn() + 2] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️");
    }

    public void placeShipVertically(String[][] boardgame, Coordinate coordinate) {
        boardgame[coordinate.getRow()][coordinate.getColumn()] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️");
        boardgame[coordinate.getRow() - 1][coordinate.getColumn()] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️");
        boardgame[coordinate.getRow() - 2][coordinate.getColumn()] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️️️️");
        boardgame[coordinate.getRow() + 1][coordinate.getColumn()] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️️");
        boardgame[coordinate.getRow() + 2][coordinate.getColumn()] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️");
    }

    public boolean isPlacingShipHorizontallyPossible(String[][] boardgame, Coordinate coordinate) {
        try {
            if (boardgame[coordinate.getRow()][coordinate.getColumn()].equals("🌊") && boardgame[coordinate.getRow()][coordinate.getColumn() - 1].equals("🌊") && boardgame[coordinate.getRow()][coordinate.getColumn() - 2].equals("🌊") && boardgame[coordinate.getRow()][coordinate.getColumn() + 1].equals("🌊") && boardgame[coordinate.getRow()][coordinate.getColumn() + 2].equals("🌊")) {
                return true;
            }
        } catch (Exception error) {
            return false;
        }
        return false;
    }

    public boolean isPlacingShipVerticallyPossible(String[][] boardgame, Coordinate coordinate) {
        try {
            if (boardgame[coordinate.getRow()][coordinate.getColumn()].equals("🌊") && boardgame[coordinate.getRow() - 1][coordinate.getColumn()].equals("🌊") && boardgame[coordinate.getRow() - 2][coordinate.getColumn()].equals("🌊") && boardgame[coordinate.getRow() + 1][coordinate.getColumn()].equals("🌊") && boardgame[coordinate.getRow() + 2][coordinate.getColumn()].equals("🌊")) {
                return true;
            }
        } catch (Exception error) {
            return false;
        }
        return false;
    }
}
