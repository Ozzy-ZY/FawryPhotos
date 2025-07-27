public class CityZone {
    private final String name;
    private final Coordinate centerCoordinate;
    private final int radius;
    public CityZone(String name,int longitude, int latitude, int radius) {
        this.name = name;
        this.centerCoordinate = new Coordinate(longitude, latitude);
        this.radius = radius;
    }
    public Boolean inRange(Coordinate other) {
        if(other.latitude() > this.centerCoordinate.latitude() + radius)
            return false;
        return other.longitude() <= this.centerCoordinate.longitude() + radius;
    }
    public String getName() {
        return name;
    }
}
