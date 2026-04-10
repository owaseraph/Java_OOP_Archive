import java.util.*;
public class Problem8 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java JaggedMatrixOps <number_of_rows>");
            return;
        }

        int m = Integer.parseInt(args[0]);
        int[][] matrix = new int[m][];
        Scanner scanner = new Scanner(System.in);

        // Read matrix from keyboard
        for (int i = 0; i < m; i++) {
            matrix[i] = new int[i + 1];
            System.out.println("Enter " + (i + 1) + " elements for row " + (i + 1) + ":");
            for (int j = 0; j <= i; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Display menu
        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Display matrix by rows");
            System.out.println("2. Display matrix by columns");
            System.out.println("3. Zero elements outside interval");
            System.out.println("4. Display neighbouring elements");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayByRows(matrix);
                    break;
                case 2:
                    displayByColumns(matrix);
                    break;
                case 3:
                    System.out.print("Enter lower limit: ");
                    int low = scanner.nextInt();
                    System.out.print("Enter upper limit: ");
                    int high = scanner.nextInt();
                    zeroOutsideInterval(matrix, low, high);
                    break;
                case 4:
                    System.out.print("Row (0-based): ");
                    int row = scanner.nextInt();
                    System.out.print("Col (0-based): ");
                    int col = scanner.nextInt();
                    displayNeighbours(matrix, row, col);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Display matrix by rows
    public static void displayByRows(int[][] matrix) {
        System.out.println("Matrix by rows:");
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    // Display matrix by columns
    public static void displayByColumns(int[][] matrix) {
        int m = matrix.length;
        int maxCols = matrix[m - 1].length;
        System.out.println("Matrix by columns:");
        for (int col = 0; col < maxCols; col++) {
            for (int row = 0; row < m; row++) {
                if (col < matrix[row].length)
                    System.out.print(matrix[row][col] + " ");
                else
                    System.out.print("  "); // skip for jagged
            }
            System.out.println();
        }
    }

    // Zero elements outside [low, high]
    public static void zeroOutsideInterval(int[][] matrix, int low, int high) {
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++)
                if(matrix[i][j] < low || matrix[i][j] > high)
                    matrix[i][j] = 0;
        System.out.println("Matrix updated (elements outside [" + low + "," + high + "] turned to 0).");
    }

    // Display existing neighbours of a given element
    public static void displayNeighbours(int[][] mat, int row, int col) {
        int m = mat.length;
        if(row < 0 || row >= m || col < 0 || col >= mat[row].length) {
            System.out.println("Invalid indexes.");
            return;
        }
        System.out.println("Neighbours of [" + row + "][" + col + "]:");
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue; // skip the element itself
                int r = row + dr, c = col + dc;
                if (r >= 0 && r < m && c >= 0 && c < mat[r].length) {
                    System.out.printf("mat[%d][%d] = %d\n", r, c, mat[r][c]);
                }
            }
        }
    }
}