public class Point {
    private GeoLoc locA;
    private GeoLoc locB;

    public Point(GeoLoc A, GeoLoc B){
        this.locA=A;
        this.locB=B;
    }

    public GeoLoc getLocA() {
        return locA;
    }

    public GeoLoc getLocB() {
        return locB;
    }

    @Override
    public String toString(){
        return "Point A= " + locA +", Point B= " +locB;
    }
}
