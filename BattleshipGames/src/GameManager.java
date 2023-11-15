import java.util.Scanner;

class GameManager {
    private Player player1;
    private Battleship battleship;

    public GameManager() {
        this.player1 = new Player();
        this.battleship = new Battleship();
    }

    public void startPlayerVsPlayerGame(){
        player1.createBattleshipBoard();
        player1.displayBattleshipBoard();
        System.out.println();
        System.out.println("Please, place the Battleship/ it occupies 5 coordinates");
        Coordinate coordinate;
        boolean isPossible = false;
        do {
            String direction = getDirectionHorizontalOrVerticalInput();
            String userCoordinate = getCoordinateInput();
            int[] splittedUserCoordinateInt = turnCoordinateStringToInt(userCoordinate);
            coordinate = new Coordinate(splittedUserCoordinateInt[0], splittedUserCoordinateInt[1]);
            System.out.println(coordinate);
            System.out.println();
            if (direction.equals("H")) {
                isPossible = battleship.isPlacingShipHorizontallyPossible(player1.getBoardGame(),coordinate);
            } else {
                isPossible = battleship.isPlacingShipVerticallyPossible(player1.getBoardGame(),coordinate);
            }
            if (isPossible && direction.equals("H")) {
                battleship.placeShipHorizontally(player1.getBoardGame(),coordinate);
            } else if (isPossible && direction.equals("V")) {
                battleship.placeShipVertically(player1.getBoardGame(),coordinate);
            } else {
                System.out.println("error, invalid coordinate\n");
            }
        } while (!isPossible);
        player1.displayBattleshipBoard();
    }

    private static String getCoordinateInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please write a coordinate");
        String userCoordinate = scan.nextLine();
        if (isCoordinateValid(userCoordinate)) {
            return userCoordinate;
        } else {
            System.out.println("Write a valid coordinate!");
        }
        return userCoordinate;
    }

    private static boolean isCoordinateValid(String userCoordinate) {
        String[] splittedUserCoordinate = userCoordinate.toLowerCase().trim().split("");
        if (userCoordinate.trim().length() != 2 && userCoordinate.trim().length() != 3) {
            return false;
        } else if (splittedUserCoordinate[0].matches("[abcdefghij]") && splittedUserCoordinate[1].matches("[0-9]")) {
            return true;
        }
        return false;
    }

    private static int[] turnCoordinateStringToInt(String userCoordinate) {
        userCoordinate = userCoordinate.trim();
        if (!isReplaced(userCoordinate)) {
            userCoordinate = userCoordinate.replace('1', '0').replace('2', '1').replace('3', '2').replace('4', '3').replace('5', '4').replace('6', '5').replace('7', '6').replace('8', '7').replace('9', '8');
        } else {
            userCoordinate = userCoordinate.replace("10", "9");
        }
        userCoordinate = userCoordinate.toLowerCase().replace('a', '0').replace('b', '1').replace('c', '2').replace('d', '3').replace('e', '4').replace('f', '5').replace('g', '6').replace('h', '7').replace('i', '8').replace('j', '9');
        String[] splittedUserCoordinate = userCoordinate.split("");
        int[] userCoordinateInt = new int[2];
        userCoordinateInt[0] = Integer.parseInt(splittedUserCoordinate[0]);
        userCoordinateInt[1] = Integer.parseInt(splittedUserCoordinate[1]);
        return userCoordinateInt;
    }

    private static boolean isReplaced(String userCoordinate) {
        String userCoordinateCopy = userCoordinate;
        userCoordinate = userCoordinate.replace("10", "9");
        return !(userCoordinateCopy.equals(userCoordinate));
    }

    private static String getDirectionHorizontalOrVerticalInput() {
        Scanner scan = new Scanner(System.in);
        String chosenDirection;
        do {
            System.out.println("Choose direction: [H] Horizontal or [V] Vertical");
            chosenDirection = scan.nextLine().toUpperCase();
        } while (!chosenDirection.equals("H") && !chosenDirection.equals("V"));
        return chosenDirection;
    }
}