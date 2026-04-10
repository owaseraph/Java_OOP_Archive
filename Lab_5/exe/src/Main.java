import java.util.*;
public class Main {
    static Random dice = new Random();
    static Shape get_a_shape() {
        if (dice.nextInt() % 2 == 0)
            return new Rectangle(5, 3);
        else
            return new Circle(4);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        Shape[] shapes = new Shape[n];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = get_a_shape();
        }
        for (Shape shape : shapes) {
            shape.printName();
            System.out.println(shape.computeArea() + " " +shape.computePerim());
            System.out.println();
        }
    }
}