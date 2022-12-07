using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class ReportController : ControllerBase
{
	private readonly IReportLogic reportLogic;
	public ReportController(IReportLogic reportLogic)
	{
		this.reportLogic = reportLogic;
	}

	[HttpPost]
	public async Task<ActionResult<Report>> ReportPostAsync([FromBody] ReportPostDto dto)
	{
		try
		{
			int reportId = await reportLogic.ReportPostAsync(dto);
			return Ok(reportId);

		}
		catch (Exception e)
		{
			Console.WriteLine(e);
			return StatusCode(500, e.Message);
		}
	}

	[HttpGet]
	[Route("get")]
	public async Task<ActionResult<Report>> GetByIdAsync([FromQuery] int id)
	{
		try
		{
			Report report = await reportLogic.GetByIdAsync(id);
			return Ok(report);
		}
		catch (Exception e)
		{
			Console.WriteLine(e);
			return StatusCode(500, e.Message);
		}
	}
}
