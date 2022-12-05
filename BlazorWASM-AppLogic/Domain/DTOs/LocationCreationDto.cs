using Domain.Models;

namespace Domain.DTOs;

public class LocationCreationDto
{
	public String address { get; set; }
	public String town { get; set; }
	public String postCode { get; set; }
	public Country country { get; set; }
	public Coordinate coordinate { get; set; }

	public LocationCreationDto(String address, String town, String postCode, Country country, Coordinate coordinate)
	{
		this.address = address;
		this.town = town;
		this.postCode = postCode;
		this.country = country;
		this.coordinate = coordinate;
	}
}
