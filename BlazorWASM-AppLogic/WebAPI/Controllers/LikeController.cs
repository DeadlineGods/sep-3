using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class LikeController: ControllerBase
{
    private readonly IUserLogic userLogic;
    
    public LikeController(IUserLogic userLogic)
    {
        this.userLogic = userLogic;
    }
    [HttpPost]
    public async Task<ActionResult<Like>> LikePostAsync(LikePostDto dto)
    {
        try
        {
            Like like = await userLogic.LikePost(dto);
            return Ok(like);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}