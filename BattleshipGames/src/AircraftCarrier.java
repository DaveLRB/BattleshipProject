import java.util.ArrayList;

class AircraftCarrier extends Ship {
    ArrayList<Coordinate> coordinates = new ArrayList<>();

    public void placeShipHorizontally(String[][] boardgame, Coordinate coordinate) {
        boardgame[coordinate.getRow()][coordinate.getColumn()] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace(WATER_SYMBOL, SHIP_SYMBOL);
        boardgame[coordinate.getRow()+1][coordinate.getColumn()] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace(WATER_SYMBOL, SHIP_SYMBOL);
        boardgame[coordinate.getRow()+1][coordinate.getColumn()-1] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace(WATER_SYMBOL, SHIP_SYMBOL);
        boardgame[coordinate.getRow()+1][coordinate.getColumn()+1] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace(WATER_SYMBOL, SHIP_SYMBOL);
        boardgame[coordinate.getRow()][coordinate.getColumn()+1] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace(WATER_SYMBOL, SHIP_SYMBOL);
        boardgame[coordinate.getRow()][coordinate.getColumn()+2] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace(WATER_SYMBOL, SHIP_SYMBOL);
        coordinates.add(new Coordinate(coordinate.getRow(), coordinate.getColumn()));
        coordinates.add(new Coordinate(coordinate.getRow()+1, coordinate.getColumn()));
        coordinates.add(new Coordinate(coordinate.getRow()+1, coordinate.getColumn()-1));
        coordinates.add(new Coordinate(coordinate.getRow()+1, coordinate.getColumn()+1));
        coordinates.add(new Coordinate(coordinate.getRow(), coordinate.getColumn()+1));
        coordinates.add(new Coordinate(coordinate.getRow(), coordinate.getColumn()+2));
    }


    public void placeShipVertically(String[][] boardgame, Coordinate coordinate) {
        boardgame[coordinate.getRow()][coordinate.getColumn()] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace(WATER_SYMBOL, SHIP_SYMBOL);
        boardgame[coordinate.getRow()][coordinate.getColumn()+1] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace(WATER_SYMBOL, SHIP_SYMBOL);
        boardgame[coordinate.getRow()-1][coordinate.getColumn()+1] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace(WATER_SYMBOL, SHIP_SYMBOL);
        boardgame[coordinate.getRow()+1][coordinate.getColumn()+1] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace(WATER_SYMBOL, SHIP_SYMBOL);
        boardgame[coordinate.getRow()-1][coordinate.getColumn()] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace(WATER_SYMBOL, SHIP_SYMBOL);
        boardgame[coordinate.getRow()-2][coordinate.getColumn()] = boardgame[coordinate.getRow()][coordinate.getColumn()].replace(WATER_SYMBOL, SHIP_SYMBOL);
        coordinates.add(new Coordinate(coordinate.getRow(), coordinate.getColumn()));
        coordinates.add(new Coordinate(coordinate.getRow(), coordinate.getColumn()+1));
        coordinates.add(new Coordinate(coordinate.getRow()-1, coordinate.getColumn()+1));
        coordinates.add(new Coordinate(coordinate.getRow()+1, coordinate.getColumn()+1));
        coordinates.add(new Coordinate(coordinate.getRow()-1, coordinate.getColumn()));
        coordinates.add(new Coordinate(coordinate.getRow()-2, coordinate.getColumn()));

    }


    public boolean isPlacingShipHorizontallyPossible(String[][] boardgame, Coordinate coordinate) {
        try {
            if (boardgame[coordinate.getRow()][coordinate.getColumn()].equals(WATER_SYMBOL) && boardgame[coordinate.getRow()+1][coordinate.getColumn()].equals(WATER_SYMBOL) && boardgame[coordinate.getRow()+1][coordinate.getColumn() - 1].equals(WATER_SYMBOL) && boardgame[coordinate.getRow() + 1][coordinate.getColumn()+1].equals(WATER_SYMBOL) && boardgame[coordinate.getRow()][coordinate.getColumn()+1].equals(WATER_SYMBOL) && boardgame[coordinate.getRow()][coordinate.getColumn()+2].equals(WATER_SYMBOL) ) {
                return true;
            }
        } catch (Exception error) {
            return false;
        }
        return false;
    }


    public boolean isPlacingShipVerticallyPossible(String[][] boardgame, Coordinate coordinate) {
        try {
            if (boardgame[coordinate.getRow()][coordinate.getColumn()].equals(WATER_SYMBOL) && boardgame[coordinate.getRow()][coordinate.getColumn() + 1].equals(WATER_SYMBOL) && boardgame[coordinate.getRow() -1][coordinate.getColumn()+1].equals(WATER_SYMBOL) && boardgame[coordinate.getRow()+1][coordinate.getColumn() + 1].equals(WATER_SYMBOL)&& boardgame[coordinate.getRow()-1][coordinate.getColumn()].equals(WATER_SYMBOL)&& boardgame[coordinate.getRow()-2][coordinate.getColumn()].equals(WATER_SYMBOL)) {
                return true;
            }
        } catch (Exception error) {
            return false;
        }
        return false;
    }

    public ArrayList<Coordinate> getCoordinates(){
        return coordinates;
    }
}

