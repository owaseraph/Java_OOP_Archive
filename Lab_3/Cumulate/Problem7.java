import java.util.Scanner;

public class Problem7 {
    // Helper to format as binary string with leading zeros
    public static String formatBinary(int value, int bits) {
        return String.format("%" + bits + "s", Integer.toBinaryString(value)).replace(' ', '0');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value;

        // Read a value bigger than 16,777,216
        do {
            System.out.print("Enter an integer greater than 16,777,216: ");
            value = scanner.nextInt();
        } while (value <= 16777216); // Ensure it's bigger than 0x1000000

        System.out.println("\nInitial value:");
        System.out.println("Decimal: " + value);
        System.out.println("Binary : " + formatBinary(value, 32));
        System.out.println("Hex    : " + Integer.toHexString(value));

        // Isolate each byte using bit masks
        int byte1 = (value >> 24) & 0xFF; // highest
        int byte2 = (value >> 16) & 0xFF;
        int byte3 = (value >> 8) & 0xFF;
        int byte4 = value & 0xFF;         // lowest

        System.out.println("\nIsolated bytes:");
        System.out.println("Byte 1 (highest):");
        System.out.println("\tDecimal: " + byte1);
        System.out.println("\tBinary : " + formatBinary(byte1, 8));
        System.out.println("\tHex    : " + Integer.toHexString(byte1));

        System.out.println("Byte 2:");
        System.out.println("\tDecimal: " + byte2);
        System.out.println("\tBinary : " + formatBinary(byte2, 8));
        System.out.println("\tHex    : " + Integer.toHexString(byte2));

        System.out.println("Byte 3:");
        System.out.println("\tDecimal: " + byte3);
        System.out.println("\tBinary : " + formatBinary(byte3, 8));
        System.out.println("\tHex    : " + Integer.toHexString(byte3));

        System.out.println("Byte 4 (lowest):");
        System.out.println("\tDecimal: " + byte4);
        System.out.println("\tBinary : " + formatBinary(byte4, 8));
        System.out.println("\tHex    : " + Integer.toHexString(byte4));
    }
}