using System;

namespace Domain.Models;

public class Location
{
    public String address { get; set; }
    public String town { get; set; }
    public String postCode { get; set; }
    public Country country { get; set; }
    public Coordinate coordinate { get; set; }

    public Location(String address, String town, String postCode, Country country, Coordinate coordinate)
    {
        this.address = address;
        this.town = town;
        this.postCode = postCode;
        this.country = country;
        this.coordinate = coordinate;
    }
}
