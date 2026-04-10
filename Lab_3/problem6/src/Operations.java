import java.util.Random;

public class Operations {
    public static void main(String[] args) {
        Random rand = new Random();

        // Generate two random integers between 1 and 100
        int a = rand.nextInt(100) + 1;
        int b = rand.nextInt(100) + 1;

        System.out.println("Random values: a = " + a + ", b = " + b);

        // Mathematical operations
        int sum = a + b;
        int diff = a - b;
        int product = a * b;
        double quotient = (double)a / b;
        double power = Math.pow(a, b);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + diff);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        System.out.println("Power (a^b): " + power);
    }
}