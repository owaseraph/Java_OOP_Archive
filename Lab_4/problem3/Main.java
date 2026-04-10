public class Main {
    public static void main(String[] args) {
        int[][] data = {
            {100,101,99,100},
            {102,100,98,97},
            {99,100,101,102},
            {97,98,100,101}
        };
        IntMatrix m = new IntMatrix(4, 4, data);
        m.display();
        int threshold = 100;
        int count = m.count9AdjacentWithinThreshold(threshold);
        System.out.println("Number of 3x3 areas where all elements are within 5% of " + threshold + ": " + count);
    }
}
