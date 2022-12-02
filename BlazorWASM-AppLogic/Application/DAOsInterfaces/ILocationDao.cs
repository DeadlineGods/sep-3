using Domain.Models;

namespace Application.DAOsInterfaces;

public interface ILocationDao
{
	Task<Coordinate> GetCoordinatesAsync(int id);
	Task<Location> GetAsync(int id);
}
