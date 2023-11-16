import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        GameManager game = new GameManager();

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
                System.out.println("1. Place Ships Manually\n2. Place Ships Randomly");
                input.nextLine();
                String userInput = input.nextLine();

                System.out.println(userInput);
                switch(userInput){
                    case "1":
                        game.placeShipsManually(player1);
                        break;
                    case "2":
                        game.placeShipsRandomly(player1);
                        break;
                    default:
                        System.out.println("please input correct one");
                        break;
                }
                //game.startPlayerVsPlayerGame();
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
}

