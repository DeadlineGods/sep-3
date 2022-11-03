namespace Domain.Models;

public class Coordinate
{
    public long latitude{ get; set; }
    public long longitude{ get; set; }

    public Coordinate(long latitude, long longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}