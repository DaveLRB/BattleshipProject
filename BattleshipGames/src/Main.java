import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("  +++++ BATTLESHIP GAME +++++");
        System.out.println("   +++++  GET STARTED  +++++");
        System.out.println("     +++++ GAME MODE +++++ \n");
        System.out.println("     1. Player VS Player");
        System.out.println("     2. Player VS Computer");
        System.out.println("           0. Exit");
        System.out.println();
        String options = input.next();
        switch (options) {
            case "1":
                new Coordinate();
                Coordinate coordinate = getCoordinate();
                System.out.println(coordinate);
                break;
            case "2":

                break;
            case "0":
                System.out.println("Exiting Game!");
                input.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option, please input correct one");
                break;
        }
    }

    public static Coordinate getCoordinate(){
        String userCoordinate = getCoordinateInput();
        int[] splittedUserCoordinateInt = turnCoordinateStringToInt(userCoordinate);
        return new Coordinate(splittedUserCoordinateInt[0], splittedUserCoordinateInt[1]);
    }

    public static String getCoordinateInput() {
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

    public static boolean isCoordinateValid(String userCoordinate) {
        String[] splittedUserCoordinate = userCoordinate.toLowerCase().trim().split("");
        if (userCoordinate.trim().length() != 2 && userCoordinate.trim().length() != 3) {
            return false;
        } else if (splittedUserCoordinate[0].matches("[abcdefghij]") && splittedUserCoordinate[1].matches("[0-9]")) {
            return true;
        }
        return false;
    }

    public static int[] turnCoordinateStringToInt(String userCoordinate) {
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

    public static boolean isReplaced(String userCoordinate) {
        String userCoordinateCopy = userCoordinate;
        userCoordinate = userCoordinate.replace("10", "9");
        return !userCoordinateCopy.equals(userCoordinate);
    }

}
