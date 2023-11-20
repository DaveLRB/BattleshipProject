import java.util.Scanner;

public class Main {
    private static final String PLAYER_VS_PLAYER = "1";
    private static final String PLAYER_VS_COMPUTER = "2";
    private static final String EXIT_GAME = "0";

    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        GameManager game = new GameManager();

        //Scanner input = new Scanner(System.in);
        printGameMainMenu();
        Scanner input = new Scanner(System.in);
        String selectedOption = input.nextLine();
        switch (selectedOption) {
            case PLAYER_VS_PLAYER:
                playerPlay(player1, game, "1");
                playerPlay(player2, game, "2");
                do {
                    game.playerShootsMissile(player2, player2.getBoard(), "1");
                    game.playerShootsMissile(player1, player1.getBoard(), "2");
                }while(!(player1.isGameOver()) && !(player2.isGameOver()));
                if(player1.isGameOver()){
                    System.out.println("Player 2 wins");
                }else{
                    System.out.println("Player 1 wins");
                }
                //game.startPlayerVsPlayerGame();
                break;
            case PLAYER_VS_COMPUTER:

                break;
            case EXIT_GAME:
                System.out.println("Exiting Game!");
                input.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option, please input correct one");
                break;
        }

    }


    private static void playerPlay(Player player, GameManager game, String numberOfPlayer) {
        System.out.println("\nIt's the player" + numberOfPlayer + " time to choose\n");
        System.out.println("1. Place Ships Manually\n2. Place Ships Randomly");
        Scanner scan = new Scanner(System.in);
        String userInputPlayer = scan.nextLine();
        switch (userInputPlayer) {
            case "1":
                System.out.println("\nIt's the player" + numberOfPlayer + " time to choose\n");
                game.placeShipsManually(player);
                break;
            case "2":
                game.placeShipsRandomly(player);
                String choiceInput;
                do {
                    System.out.println("\n1. Continue\n2. Redo randomizer\n");
                    //input.nextLine();
                    choiceInput = scan.nextLine();
                    if (!(choiceInput.equals("1"))) {
                        if(player.getShips().isEmpty()){
                            game.placeShipsRandomly(player);
                        }else{
                            player.getShips().clear();
                            game.placeShipsRandomly(player);
                        }
                    }
                } while (!(choiceInput.equals("1")));
                break;
            default:
                System.out.println("please input correct one");
                break;
        }
    }

    private static void printGameMainMenu() {
        System.out.println("  +++++ BATTLESHIP GAME +++++");
        System.out.println("   +++++  GET STARTED  +++++");
        System.out.println("     +++++ GAME MODE +++++ \n");
        System.out.println("     " + PLAYER_VS_PLAYER + ". Player VS Player");
        System.out.println("     " + PLAYER_VS_COMPUTER + ". Player VS Computer");
        System.out.println("           " + EXIT_GAME + ". Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
    }


}

