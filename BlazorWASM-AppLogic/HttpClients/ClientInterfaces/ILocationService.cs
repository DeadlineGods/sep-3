using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ILocationService
{
	Task<Location> GetAsync(int id);
	Task<Coordinate> GetCoordinatesAsync(int id);
}
