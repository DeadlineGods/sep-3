namespace Domain.Models;

public class Location
{
    public String address{ get; set; }
    public String town{ get; set; }
    public int postCode{ get; set; }
    public Country country;
    public Coordinate coordinate { get; set; }

    public Location(String address,String town, int postCode,Coordinate coordinate)
    {
        this.address = address;
        this.town = town;
        this.postCode = postCode;
        this.coordinate = coordinate;
    }
}