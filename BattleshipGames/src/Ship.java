abstract class Ship {
    protected static final String WATER_SYMBOL = "🌊";
    protected static final String SHIP_SYMBOL = "⚓️";

    // Abstract methods to be implemented by subclasses
    public abstract void placeShipHorizontally(String[][] boardgame, Coordinate coordinate);

    public abstract void placeShipVertically(String[][] boardgame, Coordinate coordinate);

    public abstract boolean isPlacingShipHorizontallyPossible(String[][] boardgame, Coordinate coordinate);

    public abstract boolean isPlacingShipVerticallyPossible(String[][] boardgame, Coordinate coordinate);
}
