import java.util.*;

class Student {
    private String name;
    private String telNumber;
    private double averageMark;

    // Constructor
    public Student(String name, String telNumber, double averageMark) {
        this.name = name;
        this.telNumber = telNumber;
        this.averageMark = averageMark;
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getTelNumber() { return telNumber; }
    public double getAverageMark() { return averageMark; }

    public void setName(String name) { this.name = name; }
    public void setTelNumber(String telNumber) { this.telNumber = telNumber; }
    public void setAverageMark(double averageMark) { this.averageMark = averageMark; }

    @Override
    public String toString() {
        return name + " | " + telNumber + " | " + averageMark;
    }

    // Validate telephone number: must be 10 digits ignoring special chars
    public static boolean isValidTel(String input) {
        String onlyDigits = input.replaceAll("[^0-9]", "");
        return onlyDigits.length() == 10;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // Read the number of students
        System.out.print("Number of students: ");
        n = Integer.parseInt(sc.nextLine());

        Student[] students = new Student[n];

        // Read student data
        for (int i = 0; i < n; ) {
            System.out.println("Enter details for student " + (i + 1) + " (name^^^tel.number^^^average mark):");
            String input = sc.nextLine();
            String[] parts = input.split("\\^\\^\\^");

            if (parts.length != 3) {
                System.out.println("Invalid format! Try again.");
                continue;
            }
            String name = parts[0].trim();
            String telNumber = parts[1].trim();
            String avgMarkStr = parts[2].trim();

            // Validate tel number
            if (!Student.isValidTel(telNumber)) {
                System.out.println("Invalid telephone number! Enter the details again for this student.");
                continue;
            }

            double avgMark;
            try {
                avgMark = Double.parseDouble(avgMarkStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid average mark! Enter the details again for this student.");
                continue;
            }

            students[i] = new Student(name, telNumber, avgMark);
            i++; // Only increment if input is valid
        }

        // Sort students by name
        Arrays.sort(students, Comparator.comparing(Student::getName));
        System.out.println("\n--- Students sorted by name ---");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort by average mark (descending)
        Arrays.sort(students, Comparator.comparing(Student::getAverageMark).reversed());
        System.out.println("\n--- Students sorted by average mark ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}