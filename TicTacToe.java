import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        boolean isXturn = true;

        while (true) {
            printBoard(board);
            System.out.println("Player " + (isXturn ? "X" : "O") + "'s turn.");
            System.out.print("Enter row (1-3): ");
            int row = scanner.nextInt() - 1;
            System.out.print("Enter column (1-3): ");
            int col = scanner.nextInt() - 1;

            if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (board[row][col] != 0) {
                System.out.println("Position already occupied. Try again.");
                continue;
            }

            board[row][col] = isXturn ? 'X' : 'O';
            if (checkWin(board, isXturn ? 'X' : 'O')) {
                printBoard(board);
                System.out.println("Player " + (isXturn ? "X" : "O") + " wins!");
                break;
            }

            isXturn = !isXturn;
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] == 0 ? " " : board[i][j]);
                System.out.print(" | ");
            }
            System.out.println();
            System.out.println("---------");
        }
    }

    private static boolean checkWin(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }
}
