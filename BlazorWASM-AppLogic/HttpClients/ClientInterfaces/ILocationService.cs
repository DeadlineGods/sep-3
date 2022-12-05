using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ILocationService
{
	Task<Location> GetAsync(int id);
	Task<Coordinate> GetCoordinatesAsync(int id);
	Task<int> CreateAsync(LocationCreationDto dto);
}
