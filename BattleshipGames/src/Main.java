import javax.sound.midi.Soundbank;
import java.awt.*;
import java.util.Scanner;

public class Main {
    private static final String PLAYER_VS_PLAYER = "1";
    private static final String PLAYER_VS_COMPUTER = "2";
    private static final String HAND_BOOK = "3";
    private static final String EXIT_GAME = "0";

    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Player handbook = new Player();
        Player player3 = new Player();
        Player computerPlayer = new Player();
        GameManager game = new GameManager();
        GameManager playerVersusComputerGame = new GameManager();
        //Scanner input = new Scanner(System.in);
        String selectedOption;
        do {
            printGameMainMenu();
            Scanner input = new Scanner(System.in);
            selectedOption = input.nextLine();
            switch (selectedOption) {
                case PLAYER_VS_PLAYER:
                    playerPlay(player1, game, "1");
                    playerPlay(player2, game, "2");
                    do {
                        game.playerShootsMissile(player2, player2.getBoard(), "1");
                        if (player2.isGameOver()) {
                            System.out.println(Colors.BRIGHT_YELLOW + "\n" +
                                    "██████╗ ██╗      █████╗ ██╗   ██╗███████╗██████╗      ██╗    ██╗    ██╗██╗███╗   ██╗███████╗\n" +
                                    "██╔══██╗██║     ██╔══██╗╚██╗ ██╔╝██╔════╝██╔══██╗    ███║    ██║    ██║██║████╗  ██║██╔════╝\n" +
                                    "██████╔╝██║     ███████║ ╚████╔╝ █████╗  ██████╔╝    ╚██║    ██║ █╗ ██║██║██╔██╗ ██║███████╗\n" +
                                    "██╔═══╝ ██║     ██╔══██║  ╚██╔╝  ██╔══╝  ██╔══██╗     ██║    ██║███╗██║██║██║╚██╗██║╚════██║\n" +
                                    "██║     ███████╗██║  ██║   ██║   ███████╗██║  ██║     ██║    ╚███╔███╔╝██║██║ ╚████║███████║\n" +
                                    "╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝     ╚═╝     ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚══════╝\n" +
                                    "                                                                                            \n" + Colors.RESET);
                            break;
                        }
                        game.playerShootsMissile(player1, player1.getBoard(), "2");
                        if (player1.isGameOver()) {
                            System.out.println(Colors.BRIGHT_YELLOW + "\n" +
                                    "██████╗ ██╗      █████╗ ██╗   ██╗███████╗██████╗     ██████╗     ██╗    ██╗██╗███╗   ██╗███████╗\n" +
                                    "██╔══██╗██║     ██╔══██╗╚██╗ ██╔╝██╔════╝██╔══██╗    ╚════██╗    ██║    ██║██║████╗  ██║██╔════╝\n" +
                                    "██████╔╝██║     ███████║ ╚████╔╝ █████╗  ██████╔╝     █████╔╝    ██║ █╗ ██║██║██╔██╗ ██║███████╗\n" +
                                    "██╔═══╝ ██║     ██╔══██║  ╚██╔╝  ██╔══╝  ██╔══██╗    ██╔═══╝     ██║███╗██║██║██║╚██╗██║╚════██║\n" +
                                    "██║     ███████╗██║  ██║   ██║   ███████╗██║  ██║    ███████╗    ╚███╔███╔╝██║██║ ╚████║███████║\n" +
                                    "╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝    ╚══════╝     ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚══════╝\n" +
                                    "                                                                                                \n" + Colors.RESET);
                            break;
                        }
                    } while (!(player1.isGameOver()) && !(player2.isGameOver()));
                    //game.startPlayerVsPlayerGame();
                    break;
                case PLAYER_VS_COMPUTER:
                    playerPlay(player3, playerVersusComputerGame, "1");
                    computerPlay(playerVersusComputerGame, computerPlayer);
                    do {
                        playerVersusComputerGame.playerShootsMissile(computerPlayer, computerPlayer.getBoard(), "1");
                        if (computerPlayer.isGameOver()) {
                            System.out.println(Colors.BRIGHT_YELLOW + "\n" +
                                    "██████╗ ██╗      █████╗ ██╗   ██╗███████╗██████╗     ██╗    ██╗██╗███╗   ██╗███████╗\n" +
                                    "██╔══██╗██║     ██╔══██╗╚██╗ ██╔╝██╔════╝██╔══██╗    ██║    ██║██║████╗  ██║██╔════╝\n" +
                                    "██████╔╝██║     ███████║ ╚████╔╝ █████╗  ██████╔╝    ██║ █╗ ██║██║██╔██╗ ██║███████╗\n" +
                                    "██╔═══╝ ██║     ██╔══██║  ╚██╔╝  ██╔══╝  ██╔══██╗    ██║███╗██║██║██║╚██╗██║╚════██║\n" +
                                    "██║     ███████╗██║  ██║   ██║   ███████╗██║  ██║    ╚███╔███╔╝██║██║ ╚████║███████║\n" +
                                    "╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝     ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚══════╝\n" +
                                    "                                                                                    \n" +
                                    "                                                                                    \n" +
                                    "                                                                                    \n" +
                                    "                                                                                    \n" +
                                    "                                                                                    \n" +
                                    "                                                                                    \n" +
                                    "                                                                                    \n" +
                                    "                                                                                    \n" + Colors.RESET);
                            break;
                        }
                        playerVersusComputerGame.playerShootsMissile(player3, player3.getBoard());
                        if (player3.isGameOver()) {
                            //put here SYSTEM OUT OF COMPUTER WINS
                            System.out.println(Colors.BRIGHT_YELLOW + "\n" +
                                    " ██████╗██████╗ ██╗   ██╗    ██╗    ██╗██╗███╗   ██╗███████╗\n" +
                                    "██╔════╝██╔══██╗██║   ██║    ██║    ██║██║████╗  ██║██╔════╝\n" +
                                    "██║     ██████╔╝██║   ██║    ██║ █╗ ██║██║██╔██╗ ██║███████╗\n" +
                                    "██║     ██╔═══╝ ██║   ██║    ██║███╗██║██║██║╚██╗██║╚════██║\n" +
                                    "╚██████╗██║     ╚██████╔╝    ╚███╔███╔╝██║██║ ╚████║███████║\n" +
                                    " ╚═════╝╚═╝      ╚═════╝      ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚══════╝\n" +
                                    "                                                            \n" +
                                    "                                                            \n" +
                                    "                                                            \n" +
                                    "                                                            \n" +
                                    "                                                            \n" +
                                    "                                                            \n" +
                                    "                                                            \n" +
                                    "                                                            \n" + Colors.RESET);

                        }
                        //put here the random shot method
                    } while (!(player3.isGameOver()) && !(computerPlayer.isGameOver()));
                    break;
                case HAND_BOOK:
                    System.out.println(Colors.BRIGHT_CYAN + "\n" +
                            "╦═╗┬ ┬┬  ┌─┐┌─┐\n" +
                            "╠╦╝│ ││  ├┤ └─┐\n" +
                            "╩╚═└─┘┴─┘└─┘└─┘\n" + Colors.RESET);
                    System.out.println(Colors.BRIGHT_BLUE + "*************************************************************************************" + Colors.RESET);
                    System.out.println(Colors.BRIGHT_CYAN + "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n" + Colors.RESET);
                    System.out.println(Colors.BRIGHT_WHITE + "\t-> Place the ships MANUALLY or RANDOMLY\n" + Colors.RESET);
                    System.out.println(Colors.BRIGHT_WHITE + "\t-> While choosing coordinates, ALWAYS choose ROWS, and then COLUMNS (Letter/Number)\n" + Colors.RESET);
                    System.out.println(Colors.BRIGHT_WHITE + "\t-> If you HIT an enemy ship, you will keep playing!\n" + Colors.RESET);
                    System.out.println(Colors.BRIGHT_WHITE + "\t-> If you MISS it passes to the enemy player turn!\n" + Colors.RESET);
                    System.out.println(Colors.BRIGHT_WHITE + "\t-> When all ships on the enemy board are sunk YOU WIN\n" + Colors.RESET);
                    System.out.println(Colors.BRIGHT_BLUE + "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" + Colors.RESET);
                    System.out.println(Colors.BRIGHT_CYAN + "*************************************************************************************\n" + Colors.RESET);
                    showShipDemonstration(handbook, new AircraftCarrier(), game);
                    showShipDemonstration(handbook, new Battleship(), game);
                    showShipDemonstration(handbook, new Submarine(), game);
                    showShipDemonstration(handbook, new Corvette(), game);
                    showShipDemonstration(handbook, new Cruiser(), game);
                    showShipDemonstration(handbook, new Destroyer(), game);
                    System.out.println();
                    System.out.println(Colors.BRIGHT_WHITE + "1. Back to Starting Menu" + Colors.RESET);
                    String userInput;
                    do {
                        userInput = input.nextLine();
                        switch (userInput) {
                            case "1":
                                break;
                            default:
                                System.out.println(Colors.BRIGHT_RED + "Invalid option, please input correct one" + Colors.RESET);
                                break;
                        }
                    } while (!userInput.equals("1"));
                    break;
                case EXIT_GAME:
                    System.out.println(Colors.BRIGHT_YELLOW + "\n" +
                            "███████╗██╗  ██╗██╗████████╗██╗███╗   ██╗ ██████╗     ██████╗  █████╗ ████████╗████████╗██╗     ███████╗███████╗██╗  ██╗██╗██████╗ \n" +
                            "██╔════╝╚██╗██╔╝██║╚══██╔══╝██║████╗  ██║██╔════╝     ██╔══██╗██╔══██╗╚══██╔══╝╚══██╔══╝██║     ██╔════╝██╔════╝██║  ██║██║██╔══██╗\n" +
                            "█████╗   ╚███╔╝ ██║   ██║   ██║██╔██╗ ██║██║  ███╗    ██████╔╝███████║   ██║      ██║   ██║     █████╗  ███████╗███████║██║██████╔╝\n" +
                            "██╔══╝   ██╔██╗ ██║   ██║   ██║██║╚██╗██║██║   ██║    ██╔══██╗██╔══██║   ██║      ██║   ██║     ██╔══╝  ╚════██║██╔══██║██║██╔═══╝ \n" +
                            "███████╗██╔╝ ██╗██║   ██║   ██║██║ ╚████║╚██████╔╝    ██████╔╝██║  ██║   ██║      ██║   ███████╗███████╗███████║██║  ██║██║██║     \n" +
                            "╚══════╝╚═╝  ╚═╝╚═╝   ╚═╝   ╚═╝╚═╝  ╚═══╝ ╚═════╝     ╚═════╝ ╚═╝  ╚═╝   ╚═╝      ╚═╝   ╚══════╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝     \n" +
                            "                                                                                                                                   \n" + Colors.RESET);
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println(Colors.BRIGHT_RED + "Invalid option, please input correct one" + Colors.RESET);
                    break;
            }
        } while (!selectedOption.equals("0"));
    }

    private static void showShipDemonstration(Player handbook, Ship ship, GameManager game) {
        handbook.createBattleshipBoard();
        game.placeShipOnBoard(ship, handbook, new Coordinate(4, 4));
        System.out.println();
        System.out.println(Colors.BRIGHT_WHITE + "This is the " + ship.shipName + " placement\n" + Colors.RESET);
        handbook.displayBattleshipBoard();
        handbook.createBattleshipBoard();
    }

    private static void playerPlay(Player player, GameManager game, String numberOfPlayer) {
        System.out.println(Colors.BRIGHT_BLUE + "\nPlayer " + numberOfPlayer + "\n" + Colors.RESET);
        System.out.println(Colors.BRIGHT_WHITE + "1. Place Ships Manually\n2. Place Ships Randomly" + Colors.RESET);
        Scanner scan = new Scanner(System.in);
        System.out.print(Colors.BRIGHT_WHITE + "\nChoose: " + Colors.RESET);
        String userInputPlayer = scan.nextLine();
        System.out.println();
        switch (userInputPlayer) {
            case "1":
                System.out.println(Colors.BRIGHT_WHITE + "\nPlayer " + numberOfPlayer + " \n" + Colors.RESET);
                game.placeShipsManually(player);
                break;
            case "2":
                game.placeShipsRandomly(player);
                String choiceInput;
                do {
                    System.out.println(Colors.BRIGHT_WHITE + "\n1. Continue\nPress Any Key to Redo Randomizer\n" + Colors.RESET);
                    //input.nextLine();
                    System.out.print(Colors.BRIGHT_WHITE + "\nChoose: " + Colors.RESET);
                    choiceInput = scan.nextLine();

                    if (!(choiceInput.equals("1"))) {
                        if (player.getShips().isEmpty()) {
                            game.placeShipsRandomly(player);
                        } else {
                            player.getShips().clear();
                            game.placeShipsRandomly(player);
                        }
                    }
                } while (!(choiceInput.equals("1")));
                break;
            default:
                System.out.println(Colors.BRIGHT_RED + "Please input correct one" + Colors.RESET);
                break;
        }
    }

    private static void computerPlay(GameManager playerVersusComputerGame, Player computerPlayer) {
        playerVersusComputerGame.placeShipsRandomlyForComputer(computerPlayer);
    }

    private static void printGameMainMenu() {
        System.out.println(Colors.BRIGHT_YELLOW + "\n" +
                " ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄            ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄         ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ \n" +
                "▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌\n" +
                "▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀  ▀▀▀▀█░█▀▀▀▀ ▐░▌          ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░▌       ▐░▌ ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌\n" +
                "▐░▌       ▐░▌▐░▌       ▐░▌     ▐░▌          ▐░▌     ▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌       ▐░▌\n" +
                "▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌     ▐░▌          ▐░▌     ▐░▌          ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌\n" +
                "▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌     ▐░▌          ▐░▌     ▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌     ▐░░░░░░░░░░░▌\n" +
                "▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌     ▐░▌          ▐░▌     ▐░▌          ▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌     ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀ \n" +
                "▐░▌       ▐░▌▐░▌       ▐░▌     ▐░▌          ▐░▌     ▐░▌          ▐░▌                    ▐░▌▐░▌       ▐░▌     ▐░▌     ▐░▌          \n" +
                "▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌     ▐░▌          ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌ ▄▄▄▄█░█▄▄▄▄ ▐░▌          \n" +
                "▐░░░░░░░░░░▌ ▐░▌       ▐░▌     ▐░▌          ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░▌          \n" +
                " ▀▀▀▀▀▀▀▀▀▀   ▀         ▀       ▀            ▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀           \n" +
                "                                                                                                                                  \n" + Colors.RESET);

        System.out.println(Colors.BRIGHT_CYAN + "     " + PLAYER_VS_PLAYER + "\n" +
                "╔═╗┬  ┌─┐┬ ┬┌─┐┬─┐  ╦  ╦╔═╗  ╔═╗┬  ┌─┐┬ ┬┌─┐┬─┐\n" +
                "╠═╝│  ├─┤└┬┘├┤ ├┬┘  ╚╗╔╝╚═╗  ╠═╝│  ├─┤└┬┘├┤ ├┬┘\n" +
                "╩  ┴─┘┴ ┴ ┴ └─┘┴└─   ╚╝ ╚═╝  ╩  ┴─┘┴ ┴ ┴ └─┘┴└─\n" + Colors.RESET);
        System.out.println(Colors.BRIGHT_CYAN + "     " + PLAYER_VS_COMPUTER + "\n" +
                "╔═╗┬  ┌─┐┬ ┬┌─┐┬─┐  ╦  ╦╔═╗  ╔═╗╔═╗╦ ╦\n" +
                "╠═╝│  ├─┤└┬┘├┤ ├┬┘  ╚╗╔╝╚═╗  ║  ╠═╝║ ║\n" +
                "╩  ┴─┘┴ ┴ ┴ └─┘┴└─   ╚╝ ╚═╝  ╚═╝╩  ╚═╝\n" + Colors.RESET);
        System.out.println(Colors.BRIGHT_CYAN + "     " + HAND_BOOK + "\n" +
                "╦ ╦╔═╗╔╗╔╔╦╗╔╗ ╔═╗╔═╗╦╔═\n" +
                "╠═╣╠═╣║║║ ║║╠╩╗║ ║║ ║╠╩╗\n" +
                "╩ ╩╩ ╩╝╚╝═╩╝╚═╝╚═╝╚═╝╩ ╩\n" + Colors.RESET);
        System.out.println(Colors.BRIGHT_CYAN + "     " + EXIT_GAME + "\n" +
                "╔═╗─┐ ┬┬┌┬┐\n" +
                "║╣ ┌┴┬┘│ │ \n" +
                "╚═╝┴ └─┴ ┴ \n" + Colors.RESET);
        System.out.println();
        System.out.print(Colors.BRIGHT_WHITE + "Enter your choice: " + Colors.RESET);
    }


}

