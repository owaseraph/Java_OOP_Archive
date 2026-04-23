// Cylinder.java
public class Cylinder extends Shape {
    private int radius;
    private int height;

    public Cylinder(int radius, int height) {
        super("Cylinder");
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double area() {
        // Surface area = 2*PI*r*h + 2*PI*r^2
        return 2 * Math.PI * radius * height + 2 * Math.PI * radius * radius;
    }

    public int getRadius() { return radius; }
    public int getHeight() { return height; }
    public void setRadius(int radius) { this.radius = radius; }
    public void setHeight(int height) { this.height = height; }

    @Override
    public String toString() {
        return shapeName + " (radius=" + radius + ", height=" + height + ")";
    }
}
