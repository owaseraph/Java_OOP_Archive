import java.util.Scanner;

class App {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume the rest of the line

        Person[] persons = new Person[n];

        for (int i = 0; i < n; i++) {
            String name = "";
            String addr = "";
            String id = "";

            // Get valid name
            while (true) {
                System.out.println("Enter name:");
                name = sc.nextLine();
                try {
                    Person.staticIsValidName(name); // You need to implement this or adapt based on how Person constructor validates
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Get valid address
            while (true) {
                System.out.println("Enter address:");
                addr = sc.nextLine();
                try {
                    Person.staticIsValidId(addr); // Same, or check as you like
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Get valid ID
            while (true) {
                System.out.println("Enter ID:");
                id = sc.nextLine();
                try {
                    Person.staticIsValidId(id); // Same as above
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Now all fields are valid
            persons[i] = new Person(name, addr, id);
        }

        for (int i = 0; i < n; i++) {
            persons[i].print();
        }
    }
}