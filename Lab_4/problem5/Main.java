import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Step 1: Input n
        System.out.print("Enter a value n (>1): ");
        int n = scanner.nextInt();

        // Step 2: Array of random length less than n
        int arrLength = random.nextInt(n - 1) + 1; // 1 to n-1
        char[] arr = new char[arrLength];

        // Step 3: Fill with random alphanumerics
        String alphaNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < arrLength; i++) {
            arr[i] = alphaNum.charAt(random.nextInt(alphaNum.length()));
        }

        // Step 4: Display original
        System.out.print("Original array: ");
        for (char c : arr) System.out.print(c);
        System.out.println();

        // Step 5: Create String object
        String originalString = new String(arr);
        System.out.println("String object: " + originalString);

        // Step 6: Replace digits with '*'
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                arr[i] = '*';
            }
        }

        // Step 7: Display result
        System.out.print("Modified array: ");
        for (char c : arr) System.out.print(c);
        System.out.println();
        System.out.println("Modified String object: " + new String(arr));
        
        scanner.close();
    }
}