import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter authentication key (format: XXXXX-XXXXX-XXXXX-XXXXX):");
        String key = scanner.nextLine();
        scanner.close();

        // Check format
        if (!key.matches("^([A-Za-z0-9]{5}-){3}[A-Za-z0-9]{5}$")) {
            System.out.println("Invalid authentication key!");
            return;
        }

        int digits = 0;
        int letters = 0;

        // Count digits and letters
        for (char ch : key.replace("-", "").toCharArray()) {
            if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isLetter(ch)) {
                letters++;
            }
        }

        // Check further conditions
        if (letters == 0 || digits <= letters) {
            System.out.println("Invalid authentication key!");
        } else {
            System.out.println("Valid authentication key!");
            System.out.println("Digits: " + digits);
            System.out.println("Letters: " + letters);
        }
    }
}