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

    [HttpPost]
    public async Task<ActionResult> CreateBanAsync([FromBody] BanCreationDto dto)
    {
        try
        {
            await BanLogic.CreateAsync(dto);
            return Ok();
        } 
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}