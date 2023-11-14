public class Battleship {

    public static void shootMissile() {

    }

    public static void placeShipHorizontally(String[][] boardgame, Coordinate coordinate) {
        boardgame[coordinate.getRow()][coordinate.getColumn()] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️");
        boardgame[coordinate.getRow()][coordinate.getColumn() - 1] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️");
        boardgame[coordinate.getRow()][coordinate.getColumn() - 2] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️");
        boardgame[coordinate.getRow()][coordinate.getColumn() + 1] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️");
        boardgame[coordinate.getRow()][coordinate.getColumn() + 2] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️");
    }

    public static boolean isPlacingShipHorizontallyPossible(String[][] boardgame, Coordinate coordinate) {
        try {
            if (boardgame[coordinate.getRow()][coordinate.getColumn()].equals("🌊") && boardgame[coordinate.getRow()][coordinate.getColumn() - 1].equals("🌊") && boardgame[coordinate.getRow()][coordinate.getColumn() - 2].equals("🌊") && boardgame[coordinate.getRow()][coordinate.getColumn() + 1].equals("🌊") && boardgame[coordinate.getRow()][coordinate.getColumn() + 2].equals("🌊")) {
                return true;
            }
        } catch (Exception error) {
            return false;
        }
        return false;
    }
}