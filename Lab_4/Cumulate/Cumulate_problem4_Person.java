public class Person {
    private String name;
    private float latitude;
    private float longitude;

    // Explicit no-argument constructor
    public Person() {
        this.name = null;
        this.latitude = 0;
        this.longitude = 0;
    }

    // Mutators
    public void setName(String name) { this.name = name; }
    public void setLatitude(float latitude) { this.latitude = latitude; }
    public void setLongitude(float longitude) { this.longitude = longitude; }

    // Accessors
    public String getName() { return this.name; }
    public float getLatitude() { return this.latitude; }
    public float getLongitude() { return this.longitude; }

    @Override
    protected void finalize() throws Throwable {
        // Display a message when the object is garbage collected
        System.out.println("Person object with name \"" + name + "\" is being destroyed (finalized).");
        super.finalize();
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Latitude: " + latitude + ", Longitude: " + longitude;
    }
}