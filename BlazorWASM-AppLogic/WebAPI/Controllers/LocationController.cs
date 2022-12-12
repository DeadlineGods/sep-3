using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class LocationController : ControllerBase
{
	private ILocationLogic LocationLogic;

	public LocationController(ILocationLogic locationLogic)
	{
		LocationLogic = locationLogic;
	}

	/// <summary>
	/// Returns coordinates from a given location id.
	/// </summary>
	/// <param name="id"></param>
	/// <returns></returns>
	[HttpGet, Route("get-coordinates")]
	public async Task<ActionResult<Coordinate>> GetCoordinates([FromQuery] int id)
	{
		try
		{
			Coordinate coordinate = await LocationLogic.GetCoordinatesAsync(id);
			return Ok(coordinate);
		}
		catch (Exception e)
		{
			Console.WriteLine(e);
			return StatusCode(500, e.Message);
		}
	}

	/// <summary>
	/// Returns coordinates from a given location id.
	/// </summary>
	/// <param name="id"></param>
	/// <returns></returns>
	[HttpGet, Route("get")]
	public async Task<ActionResult<Coordinate>> Get([FromQuery] int id)
	{
		try
		{
			Location location = await LocationLogic.GetAsync(id);
			return Ok(location);
		}
		catch (Exception e)
		{
			Console.WriteLine(e);
			return StatusCode(500, e.Message);
		}
	}

	/// <summary>
	/// Returns a id of a created location.
	/// </summary>
	/// <param name="dto">Dto contains address, town, postCode, country, coordinates. All of the parameters are mandatory.</param>
	/// <returns></returns>
	[HttpPost, Route("create")]
	public async Task<ActionResult<int>> Create(LocationCreationDto dto)
	{
		try
		{
			int id = await LocationLogic.CreateAsync(dto);
			return Ok(id);
		}
		catch (Exception e)
		{
			Console.WriteLine(e);
			return StatusCode(500, e.Message);
		}
	}
}
