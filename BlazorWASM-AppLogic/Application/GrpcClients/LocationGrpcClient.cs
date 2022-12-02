using System.Security.Principal;
using Application.DAOsInterfaces;
using Domain.Models;
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

		return new Coordinate(coordinates.Latitude, coordinates.Longitude);
	}

	public async Task<Location> GetAsync(int id)
	{
		using var channel = GrpcChannel.ForAddress("http://localhost:6565");
		var client = new LocationService.LocationServiceClient(channel);

		var location = await client.GetAsync(new LocationId{Id = id});

		Country c = (Country)Enum.Parse(typeof(Country), location.Country);

		return new Location(location.Address, location.Town, location.PostCode, c, new Coordinate(location.Latitude, location.Longitude));
	}
}
