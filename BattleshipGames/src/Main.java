import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        GameManager game = new GameManager();

        //Scanner input = new Scanner(System.in);
        System.out.println("  +++++ BATTLESHIP GAME +++++");
        System.out.println("   +++++  GET STARTED  +++++");
        System.out.println("     +++++ GAME MODE +++++ \n");
        System.out.println("     1. Player VS Player");
        System.out.println("     2. Player VS Computer");
        System.out.println("           0. Exit");
        System.out.println();
        Scanner input = new Scanner(System.in);
        String options = input.nextLine();
        switch (options) {
            case "1":
                playerPlay(player1,game, "1");
                playerPlay(player2,game,"2");
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

    private static void playerPlay(Player player, GameManager game, String numberOfPlayer){
        System.out.println("\nIt's the player"+numberOfPlayer+" time to choose\n");
        System.out.println("1. Place Ships Manually\n2. Place Ships Randomly");
        Scanner scan = new Scanner(System.in);
        String userInputPlayer = scan.nextLine();
        switch(userInputPlayer){
            case "1":
                System.out.println("\nIt's the player"+numberOfPlayer+" time to choose\n");
                game.placeShipsManually(player);
                break;
            case "2":
                game.placeShipsRandomly(player);
                String choiceInput;
                do{
                    System.out.println("\n1. Continue\n2. Redo randomizer\n");
                    //input.nextLine();
                    choiceInput = scan.nextLine();
                    if(!(choiceInput.equals("1"))){
                        game.placeShipsRandomly(player);
                    }
                }while(!(choiceInput.equals("1")));
                break;
            default:
                System.out.println("please input correct one");
                break;
        }
    }
}

