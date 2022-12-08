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
