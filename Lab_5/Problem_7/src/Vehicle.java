public class Vehicle {
    public int max_passengers;
    public String color;
    public double max_speed;

    public Vehicle(){
        this.max_passengers=0;
        this.color="default";
        this.max_speed=0;
    }
    public Vehicle(int max_passengers, String color, double max_speed){
        this.max_passengers=max_passengers;
        this.color=color;
        this.max_speed=max_speed;
    }

    //setters
    public void setMax_passengers(int max_passengers){
        this.max_passengers=max_passengers;
    }
    public void setColor(String color){
        this.color=color;
    }
    public void setMax_speed(double max_speed){
        this.max_speed=max_speed;
    }

    //getters
    public int getMax_passengers(){
        return this.max_passengers;
    }
    public String getColor(){
        return this.color;
    }
    public double getMax_speed(){
        return this.max_speed;
    }

    @Override
    public String toString(){
        return String.format("%s(maxPassengers=%d, color='%s', maxSpeed=%.1f km/h)",
                getClass().getSimpleName(), max_passengers, color, max_speed);
    }

}
