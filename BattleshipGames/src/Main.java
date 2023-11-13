import java.util.Arrays;
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
                String userCoordinate = getCoordinateInput();
                int[] splittedUserCoordinateInt=turnCoordinateStringToInt(userCoordinate);
                Coordinate coordinate=new Coordinate(splittedUserCoordinateInt[0],splittedUserCoordinateInt[1]);
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
        if (userCoordinate.length() != 2) {
            return false;
        } else if (splittedUserCoordinate[0].matches("[abcdefghij]") && splittedUserCoordinate[1].matches("[0-9]")) {
            return true;
        }
        return false;
    }

    public static int[] turnCoordinateStringToInt(String userCoordinate) {
        userCoordinate = userCoordinate.replace('a', '1').replace('b', '2').replace('c', '3').replace('d', '4').replace('e', '5').replace('f', '6').replace('g', '7').replace('h', '8').replace('i', '9').replace("j", "10");
        String[] splittedUserCoordinate = userCoordinate.split("");
        int[] userCoordinateInt = new int[2];
        userCoordinateInt[0] =Integer.parseInt(splittedUserCoordinate[0]);
        userCoordinateInt[1]=Integer.parseInt(splittedUserCoordinate[1]);
        return userCoordinateInt;
    }

}
