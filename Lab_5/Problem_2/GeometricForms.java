import java.util.*;

interface GeometricForm {
    double getArea();
    double getPerimeter();
}

class Square implements GeometricForm {
    private double side;
    public Square(double side) { this.side = side; }
    public double getArea() { return side * side; }
    public double getPerimeter() { return 4 * side; }
}

class Rectangle implements GeometricForm {
    private double width, height;
    public Rectangle(double width, double height) { this.width = width; this.height = height; }
    public double getArea() { return width * height; }
    public double getPerimeter() { return 2 * (width + height); }
}

class Circle implements GeometricForm {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    public double getArea() { return Math.PI * radius * radius; }
    public double getPerimeter() { return 2 * Math.PI * radius; }
}

class EquilateralTriangle implements GeometricForm {
    private double side;
    public EquilateralTriangle(double side) { this.side = side; }
    public double getArea() { return (Math.sqrt(3) / 4) * side * side; }
    public double getPerimeter() { return 3 * side; }
}

class IsoscelesTriangle implements GeometricForm {
    private double base, leg;
    public IsoscelesTriangle(double base, double leg) { this.base = base; this.leg = leg; }
    public double getArea() {
        // height = sqrt(leg^2 - (base/2)^2)
        double height = Math.sqrt(leg * leg - (base / 2) * (base / 2));
        return (base * height) / 2;
    }
    public double getPerimeter() { return 2 * leg + base; }
}

public class GeometricForms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<GeometricForm> forms = new ArrayList<>();
        System.out.print("Enter the number of geometric forms (N): ");
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            System.out.println("Form " + (i + 1) + ": Type (square, rectangle, circle, equilateral_triangle, isosceles_triangle):");
            String type = sc.nextLine().trim().toLowerCase();
            switch (type) {
                case "square":
                    System.out.print("Enter side: ");
                    double side = sc.nextDouble(); sc.nextLine();
                    forms.add(new Square(side));
                    break;
                case "rectangle":
                    System.out.print("Enter width and height: ");
                    double width = sc.nextDouble();
                    double height = sc.nextDouble(); sc.nextLine();
                    forms.add(new Rectangle(width, height));
                    break;
                case "circle":
                    System.out.print("Enter radius: ");
                    double radius = sc.nextDouble(); sc.nextLine();
                    forms.add(new Circle(radius));
                    break;
                case "equilateral_triangle":
                    System.out.print("Enter side: ");
                    double eqSide = sc.nextDouble(); sc.nextLine();
                    forms.add(new EquilateralTriangle(eqSide));
                    break;
                case "isosceles_triangle":
                    System.out.print("Enter base and leg:");
                    double base = sc.nextDouble();
                    double leg = sc.nextDouble(); sc.nextLine();
                    forms.add(new IsoscelesTriangle(base, leg));
                    break;
                default:
                    System.out.println("Unrecognized type, skipping.");
            }
        }

        double totalArea = 0, totalPerimeter = 0;
        for (GeometricForm f : forms) {
            totalArea += f.getArea();
            totalPerimeter += f.getPerimeter();
        }
        System.out.printf("Total area: %.4f\n", totalArea);
        System.out.printf("Total perimeter: %.4f\n", totalPerimeter);
    }
}
