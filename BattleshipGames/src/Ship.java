import java.util.ArrayList;

abstract class Ship {
    protected static final String WATER_SYMBOL = "🌊";
    protected static final String SHIP_SYMBOL = "⚓️";
    protected static final String BOMB_SYMBOL = "💥";
    protected ArrayList<Coordinate> coordinates = new ArrayList<>();

    // Abstract methods to be implemented by subclasses
    public abstract void placeShipHorizontally(String[][] boardgame, Coordinate coordinate);

    public abstract void placeShipVertically(String[][] boardgame, Coordinate coordinate);

    public abstract boolean isPlacingShipHorizontallyPossible(String[][] boardgame, Coordinate coordinate);

    public abstract boolean isPlacingShipVerticallyPossible(String[][] boardgame, Coordinate coordinate);

    public abstract ArrayList<Coordinate> getCoordinates();

    protected void placeShip(String[][] boardgame, Coordinate[] shipCoordinates) {
        for (Coordinate coordinate : shipCoordinates) {
            boardgame[coordinate.getRow()][coordinate.getColumn()] = SHIP_SYMBOL;
            coordinates.add(coordinate);
        }
    }
}
