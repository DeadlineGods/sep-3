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

	/// <summary>
	/// Returns a newly created report.
	/// </summary>
	/// <param name="dto">Dto contains violationDesc (violation description), postId, userId. ALl of the parameters are mandatory.</param>
	/// <returns></returns>
	[HttpPost]
	public async Task<ActionResult<Report>> ReportPostAsync([FromBody] ReportPostDto dto)
	{
		try
		{
			long reportId = await reportLogic.ReportPostAsync(dto);
			return Ok(reportId);

		}
		catch (Exception e)
		{
			Console.WriteLine(e);
			return StatusCode(500, e.Message);
		}
	}

	/// <summary>
	/// Returns report from a given id.
	/// </summary>
	/// <param name="id"></param>
	/// <returns></returns>
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

	/// <summary>
	/// Returns all list of all reports.
	/// </summary>
	/// <returns></returns>
	[HttpGet]
	public async Task<ActionResult<IEnumerable<Report>>> GetAsync()
	{
		try
		{
			IEnumerable<Report> reports = await reportLogic.GetAsync();
			return Ok(reports);
		}
		catch (Exception e)
		{
			Console.WriteLine(e);
			return StatusCode(500, e.Message);
		}
	}
}
