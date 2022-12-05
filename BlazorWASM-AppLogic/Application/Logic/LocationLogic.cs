using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class LocationLogic : ILocationLogic
{
	private ILocationDao dao;

	public LocationLogic(ILocationDao dao)
	{
		this.dao = dao;
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
		return await dao.CreateAsync(dto);
	}
}
