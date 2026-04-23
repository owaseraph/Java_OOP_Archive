interface Calculator {
    double add(double x, double y);
    double subtract(double x, double y);
    double multiply(double x, double y);
    double divide(double x, double y);
    double sqrt(double x, double dummy); // second param ignored
    double pow(double x, double y);
}

class CalculatorImpl implements Calculator {
    public double add(double x, double y) { return x + y; }
    public double subtract(double x, double y) { return x - y; }
    public double multiply(double x, double y) { return x * y; }
    public double divide(double x, double y) { return x / y; }
    public double sqrt(double x, double dummy) { return Math.sqrt(x); }
    public double pow(double x, double y) { return Math.pow(x, y); }
}

public class ClassicCalc{
    public static void main(String[] args) {
        Calculator calc = new CalculatorImpl();
        System.out.println("Add(5, 3): " + calc.add(5, 3));
        System.out.println("Subtract(5, 3): " + calc.subtract(5, 3));
        System.out.println("Multiply(5, 3): " + calc.multiply(5, 3));
        System.out.println("Divide(5, 2): " + calc.divide(5, 2));
        System.out.println("Sqrt(16, 0): " + calc.sqrt(16, 0));
        System.out.println("Pow(2, 5): " + calc.pow(2, 5));
    }
}
