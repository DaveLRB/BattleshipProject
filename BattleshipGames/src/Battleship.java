public class Battleship{

    public static void shootMissile(){

    }

    public static void placeShipHorizontally(String[][] boardgame, Coordinate coordinate) {
        boardgame[coordinate.getRow()][coordinate.getColumn()] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace("🌊", "⚓️");
        boardgame[coordinate.getRow()][coordinate.getColumn()] = boardgame[coordinate.getRow() - 1][coordinate.getColumn()].replace("🌊", "⚓️");
        boardgame[coordinate.getRow()][coordinate.getColumn()] = boardgame[coordinate.getRow() - 2][coordinate.getColumn()].replace("🌊", "⚓️");
        boardgame[coordinate.getRow()][coordinate.getColumn()] = boardgame[coordinate.getRow() + 1][coordinate.getColumn()].replace("🌊", "⚓️");
        boardgame[coordinate.getRow()][coordinate.getColumn()] = boardgame[coordinate.getRow() + 2][coordinate.getColumn()].replace("🌊", "⚓️");
    }

    public static boolean isPlacingShipHorizontallyPossible(String[][] boardgame, Coordinate coordinate) {
        if (boardgame[coordinate.getRow()][coordinate.getColumn()].equals("🌊") && boardgame[coordinate.getRow()][coordinate.getColumn() - 1].equals("🌊") && boardgame[coordinate.getRow()][coordinate.getColumn() - 2].equals("🌊") && boardgame[coordinate.getRow()][coordinate.getColumn() + 1].equals("🌊") && boardgame[coordinate.getRow()][coordinate.getColumn() + 2].equals("🌊")) {
            return true;
        }
        return false;
    }
}