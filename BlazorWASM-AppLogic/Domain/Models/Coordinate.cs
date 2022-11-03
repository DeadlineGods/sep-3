namespace DefaultNamespace;

public class Coordinate
{
    public long latitude{ get; set; }
    public long longitude{ get; set; }

    public Coordinate(long latitude, long longitude)
    {
        this.latitide = latitude;
        this.longitude = longitude;
    }
}