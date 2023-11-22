import javax.sound.midi.Soundbank;
import java.awt.*;
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
                    System.out.println(Colors.BRIGHT_WHITE + "\n1. Continue\n2. Redo Randomizer\n" + Colors.RESET);
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

        System.out.println(Colors.CYAN + "     " + PLAYER_VS_PLAYER + "\n" +
                "╔═╗┬  ┌─┐┬ ┬┌─┐┬─┐  ╦  ╦╔═╗  ╔═╗┬  ┌─┐┬ ┬┌─┐┬─┐\n" +
                "╠═╝│  ├─┤└┬┘├┤ ├┬┘  ╚╗╔╝╚═╗  ╠═╝│  ├─┤└┬┘├┤ ├┬┘\n" +
                "╩  ┴─┘┴ ┴ ┴ └─┘┴└─   ╚╝ ╚═╝  ╩  ┴─┘┴ ┴ ┴ └─┘┴└─\n" + Colors.RESET);
        System.out.println(Colors.CYAN + "     " + PLAYER_VS_COMPUTER + "\n" +
                "╔═╗┬  ┌─┐┬ ┬┌─┐┬─┐  ╦  ╦╔═╗  ╔═╗╔═╗╦ ╦\n" +
                "╠═╝│  ├─┤└┬┘├┤ ├┬┘  ╚╗╔╝╚═╗  ║  ╠═╝║ ║\n" +
                "╩  ┴─┘┴ ┴ ┴ └─┘┴└─   ╚╝ ╚═╝  ╚═╝╩  ╚═╝\n" + Colors.RESET);
        System.out.println(Colors.CYAN + "     " + EXIT_GAME + "\n" +
                "╔═╗─┐ ┬┬┌┬┐\n" +
                "║╣ ┌┴┬┘│ │ \n" +
                "╚═╝┴ └─┴ ┴ \n" + Colors.RESET);
        System.out.println();
        System.out.print(Colors.BRIGHT_WHITE + "Enter your choice: " + Colors.RESET);
    }


}

