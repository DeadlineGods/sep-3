using System.Reflection.Metadata;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Grpc.Core;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class AdminController : ControllerBase
{

	private readonly IAdminLogic adminLogic;

	public AdminController(IAdminLogic adminLogic)
	{
		this.adminLogic = adminLogic;
	}

	/// <summary>
	/// Returns a admin for a given username, if the username is null it will return a list of admins.
	/// </summary>
	/// <param name="username">Search parameter is optional</param>
	/// <returns></returns>
	[HttpGet]
	public async Task<ActionResult<Admin>> GetAsync([FromQuery] string? username)
	{
		try
		{
			IEnumerable<Admin> admins = await adminLogic.GetAsync(username);
			return Ok(admins);
		}
		catch (Exception e)
		{
			Console.WriteLine(e);
			return StatusCode(500, e.Message);
		}
	}
}
