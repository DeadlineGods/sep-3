namespace Domain.Models;

public class Coordinate
{
    public float latitude{ get; set; }
    public float longitude{ get; set; }

    public Coordinate(float latitude, float longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
