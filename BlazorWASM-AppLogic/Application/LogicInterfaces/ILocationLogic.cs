using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface ILocationLogic
{
	Task<Coordinate> GetCoordinatesAsync(int id);
	Task<Location> GetAsync(int id);
	Task<int> CreateAsync(LocationCreationDto dto);
}
