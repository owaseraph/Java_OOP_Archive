public class FuncCalcLambda{
    // Define lambdas for each operation
    AddOperation add = (x, y) -> x + y;
    SubtractOperation subtract = (x, y) -> x - y;
    MultiplyOperation multiply = (x, y) -> x * y;
    DivideOperation divide = (x, y) -> y != 0 ? x / y : Double.NaN;
    SqrtOperation sqrt = (x, y) -> Math.sqrt(x); // y ignored
    PowOperation pow = (x, y) -> Math.pow(x, y);

    public static void main(String[] args) {
        FunctionalCalculatorWithLambdas calc = new FunctionalCalculatorWithLambdas();

        System.out.println("Add(4, 5): " + calc.add.operate(4, 5));           // 9.0
        System.out.println("Subtract(4, 5): " + calc.subtract.operate(4, 5)); // -1.0
        System.out.println("Multiply(4, 5): " + calc.multiply.operate(4, 5)); // 20.0
        System.out.println("Divide(20, 4): " + calc.divide.operate(20, 4));   // 5.0
        System.out.println("Sqrt(16, any): " + calc.sqrt.operate(16, 0));     // 4.0
        System.out.println("Pow(2, 8): " + calc.pow.operate(2, 8));           // 256.0
    }
}
