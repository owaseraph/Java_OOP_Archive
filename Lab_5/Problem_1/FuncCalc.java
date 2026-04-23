@FunctionalInterface
interface AddOperation {
    double add(double x, double y);
}

@FunctionalInterface
interface SubtractOperation {
    double subtract(double x, double y);
}

@FunctionalInterface
interface MultiplyOperation {
    double multiply(double x, double y);
}

@FunctionalInterface
interface DivideOperation {
    double divide(double x, double y);
}

class FuncCalc {
    AddOperation addOp = (x, y) -> x + y;
    SubtractOperation subOp = (x, y) -> x - y;
    MultiplyOperation mulOp = (x, y) -> x * y;
    DivideOperation divOp = (x, y) -> x / y;

    // Example check methods (useful for demonstration)
    void checkOperations() {
        System.out.println("Add(8,2): " + addOp.add(8,2));
        System.out.println("Subtract(8,2): " + subOp.subtract(8,2));
        System.out.println("Multiply(8,2): " + mulOp.multiply(8,2));
        System.out.println("Divide(8,2): " + divOp.divide(8,2));
    }
}

public class TestFunctionalCalculator {
    public static void main(String[] args) {
        FunctionalCalculator calc = new FunctionalCalculator();
        calc.checkOperations();
    }
}
