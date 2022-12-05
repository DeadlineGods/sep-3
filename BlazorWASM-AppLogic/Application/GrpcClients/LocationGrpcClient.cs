using System.Security.Principal;
using Application.DAOsInterfaces;
using Domain.DTOs;
using Domain.Models;
using Google.Protobuf;
using Grpc.Net.Client;
using GrpcClient;

namespace Application.GrpcClients;

public class LocationGrpcClient : ILocationDao
{
	/**
	 * Get coordinates with id
	 * Id can be obtained from user or post
	 */
	public async Task<Coordinate> GetCoordinatesAsync(int id)
	{
		using var channel = GrpcChannel.ForAddress("http://localhost:6565");
		var client = new LocationService.LocationServiceClient(channel);

		var coordinates = await client.GetCoordinatesAsync(new LocationId{Id = id});

		if (coordinates.Equals(new CoordinatesData()))
		{
			throw new Exception("There was an error while getting coordinates from database. Please try again later.");
		}

		return new Coordinate(coordinates.Latitude, coordinates.Longitude);
	}

	public async Task<Location> GetAsync(int id)
	{
		using var channel = GrpcChannel.ForAddress("http://localhost:6565");
		var client = new LocationService.LocationServiceClient(channel);

		var location = await client.GetAsync(new LocationId{Id = id});

		// data was not returned correctly
		if (location.Equals(new LocationData()))
		{
			throw new Exception("There was an error while getting location from database. Please try again later.");
		}

		Country c = (Country) Enum.Parse(typeof(Country), location.Country);

		return new Location(location.Address, location.Town, location.PostCode, c, new Coordinate(location.Latitude, location.Longitude));
	}

	public async Task<int> CreateAsync(LocationCreationDto dto)
	{
		using var channel = GrpcChannel.ForAddress("http://localhost:6565");
		var client = new LocationService.LocationServiceClient(channel);

		var request = new LocationData()
		{
			Address = dto.address,
			PostCode = dto.postCode,
			Country = dto.country.ToString(),
			Town = dto.town,
			Latitude = dto.coordinate.latitude,
			Longitude = dto.coordinate.longitude,
		};

		var reply = await client.CreateAsync(request);

		if (reply.Equals(new LocationId()))
		{
			throw new Exception("Creation was not successful.");
		}

		return await Task.FromResult(reply.Id);
	}
}
