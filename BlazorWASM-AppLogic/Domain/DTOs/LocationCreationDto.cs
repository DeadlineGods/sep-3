using Domain.Models;

namespace Domain.DTOs;

public class LocationCreationDto
{
	public string address { get; set; }
	public string town { get; set; }
	public string postCode { get; set; }
	public Country country { get; set; }
	public Coordinate coordinate { get; set; }

	public LocationCreationDto(string address, string town, string postCode, Country country, Coordinate coordinate)
	{
		this.address = address;
		this.town = town;
		this.postCode = postCode;
		this.country = country;
		this.coordinate = coordinate;
	}
}
