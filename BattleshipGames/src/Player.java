public class Player {

    private String[][] boardGame = new String[10][10];
    private final int sizeOfRowsAndColumns = 10;

    public void createBattleshipBoard() {
        for (int row = 0; row < sizeOfRowsAndColumns; row++) {
            for (int col = 0; col < sizeOfRowsAndColumns; col++) {
                boardGame[row][col] = "🌊";
            }
        }
    }

    public void displayBattleshipBoard() {
        // Print an empty space for alignment with the numbers
        System.out.print("     ");

        numbers();
        System.out.println();

        for (int row = 0; row < sizeOfRowsAndColumns; row++) {
            // Print the row number
            System.out.printf("%-3d", (row + 1));

            for (int col = 0; col < sizeOfRowsAndColumns; col++) {
                // Calculate the number of digits in the number
                int numDigits = (col + 1) / 10 + 1;

                // Calculate the number of spaces needed to align the emojis and numbers
                int spaces = 4 - numDigits;

                // Print the emoji and adjust the width of the column
                System.out.print(" " + boardGame[row][col] + " ".repeat(spaces));
            }
            System.out.println(); // Move to the next line for the next row
        }
    }

    private void numbers() {
        for (int i = 0; i < 10; i++) {
            // Print the number and adjust the width of the column
            System.out.printf("%-5d", (i + 1));
        }
    }
}
