public class Circle extends C1 {
    private double r;

    public Circle(double r) {
        super("Circle");
        this.r = r;
    }

    @Override
    public double computeArea() {
        return Math.PI*r*r;
    }

    @Override
    public double computePerim() {
        return 2*Math.PI * r;
    }
}