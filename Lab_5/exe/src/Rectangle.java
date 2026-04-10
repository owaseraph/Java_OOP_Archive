public class Rectangle extends C1 {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    public double computeArea() {
        return width * height;
    }

    @Override
    public double computePerim() {
        return 2 * (width + height);
    }
}