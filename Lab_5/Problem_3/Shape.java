// Shape.java
public abstract class Shape {
    protected String shapeName;

    public Shape(String name) {
        this.shapeName = name;
    }

    public abstract double area();

    @Override
    public String toString() {
        return shapeName;
    }

    public void setName(String shapeName) {
        this.shapeName = shapeName;
    }

    public String getName() {
        return shapeName;
    }
}
