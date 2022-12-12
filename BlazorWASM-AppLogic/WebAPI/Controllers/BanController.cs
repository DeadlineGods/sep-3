using Application.LogicInterfaces;
using Domain.DTOs;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class BanController : ControllerBase
{
    private readonly IBanLogic BanLogic;

    public BanController(IBanLogic banLogic)
    {
        BanLogic = banLogic;
    }

    /// <summary>
    /// Returns a id of a created ban.
    /// </summary>
    /// <param name="dto">Dto contains Reason, Admin, PostId. All parameters are mandatory.</param>
    /// <returns></returns>
    [HttpPost]
    public async Task<ActionResult<long>> CreateBanAsync([FromBody] BanCreationDto dto)
    {
        try
        {
            long id = await BanLogic.CreateAsync(dto);
            return Ok(id);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    /// <summary>
    /// Returns a id of a requested ban. Ban is returned from a post.
    /// </summary>
    /// <param name="postId"></param>
    /// <returns></returns>
    [HttpGet]
    public async Task<ActionResult<long>> GetAsync([FromQuery] long postId)
    {
	    try
	    {
		    long id = await BanLogic.GetAsync(postId);
		    return Ok(id);
	    }
	    catch (Exception e)
	    {
		    Console.WriteLine(e);
		    return StatusCode(500, e.Message);
	    }
    }
}
