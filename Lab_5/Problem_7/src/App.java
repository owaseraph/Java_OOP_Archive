public class App {
    public void run(){
        GeoLoc paris    = new GeoLoc(48.8566,   2.3522);
        GeoLoc newYork  = new GeoLoc(40.7128,  -74.0060);
        GeoLoc london   = new GeoLoc(51.5074,  -0.1278);
        GeoLoc tokyo    = new GeoLoc(35.6762,  139.6503);

        MotorizedVehicle car = new MotorizedVehicle(5, "red",180,london,150);
        System.out.println(car);
        Point routeCar = new Point(london,paris);
        double durationCar = car.move(routeCar);

        Airplane air = new Airplane(10,"blue",10000,paris,7863,12000);
        System.out.println(air);

        Point routeAir = new Point(paris,tokyo);
        double durationAir = air.move(routeAir);
    }
}
