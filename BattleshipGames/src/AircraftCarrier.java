import java.util.ArrayList;

class AircraftCarrier extends Ship {

    public AircraftCarrier() {
        shipName="Aircraft Carrier";
    }

    public void placeShipHorizontally(String[][] boardgame, Coordinate coordinate) {
        Coordinate[] shipCoordinates = {
                new Coordinate(coordinate.getRow(), coordinate.getColumn()),
                new Coordinate(coordinate.getRow() + 1, coordinate.getColumn()),
                new Coordinate(coordinate.getRow() + 1, coordinate.getColumn() - 1),
                new Coordinate(coordinate.getRow() + 1, coordinate.getColumn() + 1),
                new Coordinate(coordinate.getRow(), coordinate.getColumn() + 1),
                new Coordinate(coordinate.getRow(), coordinate.getColumn() + 2)
        };
        placeShip(boardgame, shipCoordinates);
    }

    public void placeShipVertically(String[][] boardgame, Coordinate coordinate) {
        Coordinate[] shipCoordinates = {
                new Coordinate(coordinate.getRow(), coordinate.getColumn()),
                new Coordinate(coordinate.getRow(), coordinate.getColumn() + 1),
                new Coordinate(coordinate.getRow() - 1, coordinate.getColumn() + 1),
                new Coordinate(coordinate.getRow() + 1, coordinate.getColumn() + 1),
                new Coordinate(coordinate.getRow() - 1, coordinate.getColumn()),
                new Coordinate(coordinate.getRow() - 2, coordinate.getColumn())
        };
        placeShip(boardgame, shipCoordinates);
    }


    public boolean isPlacingShipHorizontallyPossible(String[][] boardgame, Coordinate coordinate) {
        try {
            if (boardgame[coordinate.getRow()][coordinate.getColumn()].equals(WATER_SYMBOL) && boardgame[coordinate.getRow() + 1][coordinate.getColumn()].equals(WATER_SYMBOL) && boardgame[coordinate.getRow() + 1][coordinate.getColumn() - 1].equals(WATER_SYMBOL) && boardgame[coordinate.getRow() + 1][coordinate.getColumn() + 1].equals(WATER_SYMBOL) && boardgame[coordinate.getRow()][coordinate.getColumn() + 1].equals(WATER_SYMBOL) && boardgame[coordinate.getRow()][coordinate.getColumn() + 2].equals(WATER_SYMBOL)) {
                return true;
            }
        } catch (Exception error) {
            return false;
        }
        return false;
    }


    public boolean isPlacingShipVerticallyPossible(String[][] boardgame, Coordinate coordinate) {
        try {
            if (boardgame[coordinate.getRow()][coordinate.getColumn()].equals(WATER_SYMBOL) && boardgame[coordinate.getRow()][coordinate.getColumn() + 1].equals(WATER_SYMBOL) && boardgame[coordinate.getRow() - 1][coordinate.getColumn() + 1].equals(WATER_SYMBOL) && boardgame[coordinate.getRow() + 1][coordinate.getColumn() + 1].equals(WATER_SYMBOL) && boardgame[coordinate.getRow() - 1][coordinate.getColumn()].equals(WATER_SYMBOL) && boardgame[coordinate.getRow() - 2][coordinate.getColumn()].equals(WATER_SYMBOL)) {
                return true;
            }
        } catch (Exception error) {
            return false;
        }
        return false;
    }

    public ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }
}

