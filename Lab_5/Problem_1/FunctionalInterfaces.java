@FunctionalInterface
interface AddOperation {
    double operate(double x, double y);
}
@FunctionalInterface
interface SubtractOperation {
    double operate(double x, double y);
}
@FunctionalInterface
interface MultiplyOperation {
    double operate(double x, double y);
}
@FunctionalInterface
interface DivideOperation {
    double operate(double x, double y);
}
@FunctionalInterface
interface SqrtOperation {
    double operate(double x, double y); // y ignored
}
@FunctionalInterface
interface PowOperation {
    double operate(double x, double y);
}
