using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Geocoding;
using Geocoding.Google;
using Location = Domain.Models.Location;

namespace Application.Logic;

public class LocationLogic : ILocationLogic
{
	private ILocationDao dao;
	private GoogleGeocoder geocoder;

	public LocationLogic(ILocationDao dao)
	{
		this.dao = dao;
		geocoder = new GoogleGeocoder()
		{
			ApiKey = "AIzaSyBWOfx3pXBNiaG9aRvUjhHfFV8NqEZlsio"
		};
	}

	public async Task<Coordinate> GetCoordinatesAsync(int id)
	{
		return await dao.GetCoordinatesAsync(id);
	}

	public async Task<Location> GetAsync(int id)
	{
		return await dao.GetAsync(id);
	}

	public async Task<int> CreateAsync(LocationCreationDto dto)
	{
		// TODO maybe check if there is such a data in db already
		
		dto = await GetAddressFromCoordinates(dto.coordinate);

		return await dao.CreateAsync(dto);
	}

	private async Task<LocationCreationDto> GetAddressFromCoordinates(Coordinate coordinate)
	{
		IEnumerable<GoogleAddress> addresses = await geocoder.ReverseGeocodeAsync(coordinate.latitude, coordinate.longitude);
		var country = addresses.Where(a => !a.IsPartialMatch).Select(a => a[GoogleAddressType.Country]).First();
		var town = addresses.Where(a => !a.IsPartialMatch).Select(a => a[GoogleAddressType.Locality]).First();
		var postCode = addresses.Where(a => !a.IsPartialMatch).Select(a => a[GoogleAddressType.PostalCode]).First();
		var route = addresses.Where(a => !a.IsPartialMatch).Select(a => a[GoogleAddressType.Route]).First();
		var streetNo = addresses.Where(a => !a.IsPartialMatch).Select(a => a[GoogleAddressType.StreetNumber]).First();

		Console.WriteLine(addresses.ToJSON());
		
		LocationCreationDto dto = new LocationCreationDto(
			route.ShortName + " " + streetNo.ShortName,
			town.ShortName,
			postCode.ShortName,
			(Country)Enum.Parse(typeof(Country), country.ShortName),
			coordinate);
		return dto;
	}
}
