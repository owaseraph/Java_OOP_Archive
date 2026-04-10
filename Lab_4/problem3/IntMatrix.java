public class IntMatrix {
    // Private attributes
    private int rows;
    private int cols;
    private int[][] elements;

    // Constructor
    public IntMatrix(int rows, int cols, int[][] elements) {
        this.rows = rows;
        this.cols = cols;
        setElements(elements);
    }

    // Getters and setters
    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public int[][] getElements() { return elements; }

    public void setRows(int rows) { this.rows = rows; }
    public void setCols(int cols) { this.cols = cols; }
    public void setElements(int[][] elements) {
        // Defensive copy
        this.elements = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                this.elements[i][j] = elements[i][j];
    }

    // Method to display the matrix
    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(elements[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Returns the count of 9-cell (3x3) neighborhoods whose all values don't differ
     * by more than 5% from a given threshold.
     * Only neighborhoods completely inside the matrix are considered.
     */
    public int count9AdjacentWithinThreshold(int threshold) {
        int count = 0;
        double percent = 0.05;
        int min = (int)Math.ceil(threshold - percent * threshold);
        int max = (int)Math.floor(threshold + percent * threshold);

        // scan all possible 3x3 centers
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                boolean allWithin = true;
                for (int r = i - 1; r <= i + 1 && allWithin; r++) {
                    for (int c = j - 1; c <= j + 1 && allWithin; c++) {
                        int val = elements[r][c];
                        if (val < min || val > max) {
                            allWithin = false;
                        }
                    }
                }
                if (allWithin)
                    count++;
            }
        }
        return count;
    }

    
    
}