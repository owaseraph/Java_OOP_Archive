// PaintThings.java
import java.util.Scanner;

public class PaintThings implements Paint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Rectangle (Deck)
        System.out.print("Enter the length and width of the deck: ");
        int deckLength = scanner.nextInt();
        int deckWidth = scanner.nextInt();
        Rectangle deck = new Rectangle(deckLength, deckWidth);

        // Sphere (bigBall)
        System.out.print("Enter the radius of the big ball: ");
        int ballRadius = scanner.nextInt();
        Sphere bigBall = new Sphere(ballRadius);

        // Cylinder (tank)
        System.out.print("Enter the radius and height of the tank: ");
        int tankRadius = scanner.nextInt();
        int tankHeight = scanner.nextInt();
        Cylinder tank = new Cylinder(tankRadius, tankHeight);

        // Compute paint amounts
        System.out.println();
        computePaintNeeded(deck);
        computePaintNeeded(bigBall);
        computePaintNeeded(tank);
    }

    private static void computePaintNeeded(Shape shape) {
        double area = shape.area();
        double paintNeeded = area * paintPerSurfaceUnit;
        System.out.printf("Paint needed for %s (area=%.2f): %.2f units of paint\n",
                shape.toString(), area, paintNeeded);
    }
}
