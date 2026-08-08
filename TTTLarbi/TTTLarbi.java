 /* Assignment Tic-Tac-Toe
   Name: Kwadwo Larbi
   File Created on July 2, 2026
 
 
 */
 
 /*
 BEGIN PROGRAM

    DECLARE board as 2D array of char size 3x3
    DECLARE currentPlayer as char ('X' for human, 'O' for computer)
    DECLARE winnerStatus as integer

    CALL initBoard()

    SET currentPlayer = 'X'   // human always starts

    DO
        IF currentPlayer == 'X' THEN
            CALL yourTurn()
        ELSE
            CALL machineTurn()
        ENDIF

        CALL gameBoard()

        winnerStatus = checkWinner()

        IF winnerStatus == 1 THEN
            DISPLAY "You win!"
        ELSE IF winnerStatus == -1 THEN
            DISPLAY "Computer wins!"
        ELSE IF winnerStatus == 0 THEN
            DISPLAY "It's a tie!"
        ENDIF

        SWITCH currentPlayer:
            CASE 'X': currentPlayer = 'O'
            CASE 'O': currentPlayer = 'X'
        END SWITCH

    WHILE winnerStatus == 2   // 2 means no winner yet

END PROGRAM
 */
import java.util.Scanner;

public class TTTLarbi{

    static char[][] board = new char[3][3];
    static Scanner input = new Scanner(System.in);

    
    // Initialize board
    public static void initBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = ' ';
            }
        }
    }


    // Display board 
    public static void gameBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print("!" + board[r][c]);
            }
            System.out.println("!");
        }
        System.out.println();
    }


    // Check winner
    // Return: 1 = human wins, -1 = computer wins, 0 = tie, 2 = no winner yet

    public static int checkWinner() {

        // Check rows
        for (int r = 0; r < 3; r++) {
            if (board[r][0] == board[r][1] && board[r][1] == board[r][2] && board[r][0] != ' ') {
                return (board[r][0] == 'X') ? 1 : -1;
            }
        }

        // Check columns
        for (int c = 0; c < 3; c++) {
            if (board[0][c] == board[1][c] && board[1][c] == board[2][c] && board[0][c] != ' ') {
                return (board[0][c] == 'X') ? 1 : -1;
            }
        }

        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return (board[0][0] == 'X') ? 1 : -1;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return (board[0][2] == 'X') ? 1 : -1;
        }

        // Check tie
        boolean full = true;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == ' ') full = false;
            }
        }

        if (full) return 0;

        return 2; // no winner yet
    }


    // Human turn    
    public static void yourTurn() {
        int row = -1, col = -1;
        boolean valid = false;

        while (!valid) {
            System.out.print("Please enter coordinate of your location (x): ");
            String move = input.nextLine().trim();

            // Expect format like "1,2"
            if (move.length() == 3 &&
                    Character.isDigit(move.charAt(0)) &&
                    move.charAt(1) == ',' &&
                    Character.isDigit(move.charAt(2))) {

                row = move.charAt(0) - '0';
                col = move.charAt(2) - '0';

                if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
                    if (board[row][col] == ' ') {
                        board[row][col] = 'X';
                        valid = true;
                    } else {
                        System.out.println("Cell already taken. Try again.");
                    }
                } else {
                    System.out.println("Invalid position. Try again.");
                }

            } else {
                System.out.println("Invalid format. Use row,col (e.g., 1,2)");
            }
        }
    }

 
    // Computer turn 
    public static void machineTurn() {
        int row, col;

        while (true) {
            row = (int)(Math.random() * 3);
            col = (int)(Math.random() * 3);

            if (board[row][col] == ' ') {
                board[row][col] = 'O';
                // computer place test 
               // System.out.println("Computer placed O at (" + row + ", " + col + ")");
                return;
            }
        }
    } 


    // Main game loop
    public static void main(String[] args) {

        initBoard();
        System.out.println("Let's begin!");
        gameBoard();

        int status = 2;
        
        char currentPlayer = 'X';

        while (status == 2) {

            if (currentPlayer == 'X') {
                yourTurn();
            } else {
                machineTurn();
            }

            gameBoard();
            status = checkWinner();

            if (status == 1) {
                System.out.println("You won!");
            } else if (status == -1) {
                System.out.println("You lost!");
            } else if (status == 0) {
                System.out.println("It's a tie!");
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        System.out.println("Press any key to continue...");
    } 
}
