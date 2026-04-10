public class MotorizedVehicle extends Vehicle {
    private GeoLoc position;
    double moving_speed;

    public MotorizedVehicle(int max_passengers, String color, double max_speed, GeoLoc position, double moving_speed){
        super(max_passengers,color,max_speed);
        this.position=position;
        this.moving_speed=moving_speed;
    }

    //Convenience Constructor: moving speed defaults to max speed
    public MotorizedVehicle(int max_passengers, String color, double max_speed, GeoLoc position) {
        this(max_passengers,color,max_speed,position,max_speed);
    }

    //setters
    public void setPosition(GeoLoc position){
        this.position=position;
    }
    public void setMoving_speed(double moving_speed){
        this.moving_speed=moving_speed;
    }

    //getters
    public GeoLoc getPosition(){
        return this.position;
    }
    public double getMoving_speed() {
        return moving_speed;
    }


    /**
     * moves motorized vehicle from locA to locB
     * @param destination point
     * @return trip duration in hours
     */
    public double move(Point destination){
        double distanceKM = destination.getLocA().distanceTo(destination.getLocB());
        double durationHours = distanceKM/moving_speed;


        //update current position
        this.position=destination.getLocB();

        //for debugging
        System.out.printf("[%s] Distance: %.2f km | Speed: %.1f km/h | Duration: %.4f h (%.2f min)%n",
                getClass().getSimpleName(), distanceKM, moving_speed,
                durationHours, durationHours * 60);

        return durationHours;
    }

    @Override
    public String toString(){
        return String.format("%s(maxPassengers=%d, color='%s', maxSpeed=%.1f km/h, movingSpeed=%.1f km/h)",
                getClass().getSimpleName(), max_passengers, color, max_speed,moving_speed);
    }

}
