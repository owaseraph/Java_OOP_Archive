public class Airplane extends MotorizedVehicle{
    public static final double Earth_Radius = 6371.0;

    private double altitude;

    public Airplane(int max_passenger, String color, double max_speed, GeoLoc position, double moving_speed,double altitude){
        super(max_passenger, color,max_speed,position,moving_speed);
        this.altitude=altitude;
    }

    //Convenience Constructor, moving speed defaults to max speed
    public Airplane(int max_passenger, String color, double max_speed,GeoLoc position, double altitude){
        super(max_passenger,color,max_speed,position,max_speed);
        this.altitude=altitude;
    }


    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude){
        this.altitude=altitude;
    }
    /**
     * Moves the airplane from locA to locB along the arc of a circle
     * The plane climbs from ground level at A to {@code altitude} meters
     * at the midpoint, then descends symmetrically back to B.
     *
     * @param destination point
     * @return trip duration in hours
     */
    @Override
    public double move(Point destination) {
        GeoLoc a = destination.getLocA();
        GeoLoc b = destination.getLocB();

        // 1. Central angle (radians) via Haversine
        double lat1 = Math.toRadians(a.getLatitude());
        double lat2 = Math.toRadians(b.getLatitude());
        double dLat = Math.toRadians(b.getLatitude()  - a.getLatitude());
        double dLon = Math.toRadians(b.getLongitude() - a.getLongitude());

        double ha = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double centralAngle = 2 * Math.asin(Math.sqrt(ha)); // radians

        // 2. Effective arc radius (Earth radius + average altitude)
        double altitudeKm = altitude / 1000.0;
        double rEff       = Earth_Radius + altitudeKm / 2.0;

        // 3. Arc length and duration
        double arcLengthKm   = rEff * centralAngle;
        double durationHours = arcLengthKm / getMoving_speed();

        // Update position
        setPosition(b);

        System.out.printf("[Airplane] Arc length: %.2f km | Max altitude: %.0f m | " +
                        "Speed: %.1f km/h | Duration: %.4f h (%.2f min)%n",
                arcLengthKm, altitude, getMoving_speed(), durationHours, durationHours * 60);

        return durationHours;
    }

    @Override
    public String toString() {
        return String.format("Airplane(maxPassengers=%d, color='%s', maxSpeed=%.1f km/h, " +
                        "movingSpeed=%.1f km/h, altitude=%.0f m, position=%s)",
                getMax_passengers(), getColor(), getMax_speed(),
                getMoving_speed(), altitude, getPosition());
    }
}

