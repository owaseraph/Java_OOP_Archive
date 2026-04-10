import java.util.*;

public class Problem11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for board size
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        char[][] board = new char[rows][cols];
        List<int[]> available = new ArrayList<>();
        Random rand = new Random();

        // Initialize board and list of available positions
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                board[i][j] = '*';
                available.add(new int[]{i, j});
            }

        char current = 'X';
        boolean gameEnd = false;
        int move = 0;

        while (!gameEnd && !available.isEmpty()) {
            // Pick a random available spot
            int idx = rand.nextInt(available.size());
            int[] pos = available.remove(idx);
            board[pos[0]][pos[1]] = current;

            System.out.println("Move #" + (++move) + ": Player " + current);
            printBoard(board);

            if (isWin(board, current, pos[0], pos[1])) {
                System.out.println("Player " + current + " wins!");
                gameEnd = true;
            } else if (available.isEmpty()) {
                System.out.println("It's a draw!");
                gameEnd = true;
            }

            // Alternate
            current = (current == 'X') ? 'O' : 'X';
        }
    }

    // Print the board
    static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row)
                System.out.print(cell + " ");
            System.out.println();
        }
        System.out.println();
    }

    // Check if placing at (row,col) caused a win for 'player'
    static boolean isWin(char[][] board, char player, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        boolean win;

        // Check row
        win = true;
        for (int j = 0; j < cols; j++)
            if (board[row][j] != player) {
                win = false;
                break;
            }
        if (win) return true;

        // Check column
        win = true;
        for (int i = 0; i < rows; i++)
            if (board[i][col] != player) {
                win = false;
                break;
            }
        if (win) return true;

        // Check main diagonal (if square and on diagonal)
        if (rows == cols && row == col) {
            win = true;
            for (int i = 0; i < rows; i++)
                if (board[i][i] != player) {
                    win = false;
                    break;
                }
            if (win) return true;
        }
        // Check anti-diagonal (if square and on anti-diagonal)
        if (rows == cols && row + col == rows - 1) {
            win = true;
            for (int i = 0; i < rows; i++)
                if (board[i][cols - 1 - i] != player) {
                    win = false;
                    break;
                }
            if (win) return true;
        }
        return false;
    }
}