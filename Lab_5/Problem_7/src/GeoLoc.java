public class GeoLoc {
    public double longitude;
    public double latitude;

    public GeoLoc(double latitude, double longitude){
        if(latitude<-90 || latitude>90){
            throw new IllegalArgumentException("The latitude must be between -90 and 90.");
        }
        if(longitude<-180 || longitude>180){
            throw new IllegalArgumentException("The longitude must be between -180 and 180.");
        }
        this.longitude=longitude;
        this.latitude=latitude;
    }

    public double getLongitude(){
        return this.longitude;
    }
    public double getLatitude(){
        return this.latitude;
    }

    /**
     * function to calculate the distance between 2 locations based on latitude and longitude
     * uses Harvesine formula
     * @return distance in km
     */
    public double distanceTo(GeoLoc other){
        final double R = 6371.0;
        double lat1 = Math.toRadians(this.latitude);
        double lat2 = Math.toRadians(other.latitude);

        double dLat = Math.toRadians(other.latitude - this.latitude);
        double dLon = Math.toRadians(other.longitude - this.longitude);

        //apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);

        double c = 2*Math.asin(Math.sqrt(a));

        return R*c;
    }

    @Override
    public String toString(){
        return String.format("GeoLoc(lat=%.4f°, lon=%.4f°)", latitude, longitude);
    }
}
