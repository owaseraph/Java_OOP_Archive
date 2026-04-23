// Sphere.java
public class Sphere extends Shape {
    private int radius;

    public Sphere(int radius) {
        super("Sphere");
        this.radius = radius;
    }

    @Override
    public double area() {
        return 4 * Math.PI * radius * radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return shapeName + " (radius=" + radius + ")";
    }
}
