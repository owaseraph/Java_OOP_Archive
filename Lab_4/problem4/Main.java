import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = Integer.parseInt(scanner.nextLine());

        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            people[i] = new Person();
            System.out.println("Enter data for person " + (i + 1) + ":");
            System.out.print("  Name: ");
            people[i].setName(scanner.nextLine());
            System.out.print("  Latitude: ");
            people[i].setLatitude(Float.parseFloat(scanner.nextLine()));
            System.out.print("  Longitude: ");
            people[i].setLongitude(Float.parseFloat(scanner.nextLine()));
        }

        System.out.println("\n--- All Persons ---");
        for (int i = 0; i < n; i++) {
            System.out.println(people[i]);
        }

        // Force garbage collection for demonstration purposes (not good practice in real code)
        people = null;
        System.gc();
        scanner.close();
    }
}