using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;
using Exception = System.Exception;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class UserController : ControllerBase
{
    private readonly IUserLogic userLogic;
    
    public UserController(IUserLogic userLogic)
    {
        this.userLogic = userLogic;
    }

    [HttpPost]
    public async Task<ActionResult<User>> CreateAsync(UserCreationDto userCreationDto)
    {
        try
        {
            User user = await userLogic.CreateAsync(userCreationDto);
            return Created($"/users/{user.UserName}", user);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }
    }
    [HttpGet]
    public async Task<ActionResult<User>> GetAsync
    (
        [FromQuery] string? username,
        [FromQuery] long? userId
    ) {
        try
        {
            SearchUserParametersDto parameters = new SearchUserParametersDto(username, userId);
            IEnumerable<User> users = await userLogic.GetAsync(parameters);
            return Ok(users);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    [HttpPost, Route("Like")]
    public async Task<ActionResult<Like>> LikePostAsync(LikePostDto dto)
    {
        try
        {
            Like like = await userLogic.LikePost(dto);
            return Created($"/likes/{like.likedBy}&{like.likedPost}", like);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    [HttpGet, Route("Like")]
    public async Task<ActionResult<IEnumerable<User>>> GetLikesAsync([FromQuery] int postId)
    {
        try
        {
            IEnumerable<User> users = await userLogic.GetLikes(postId);
            return Ok(users);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
        
    }

    [HttpGet, Route("likes/count")]
    public async Task<ActionResult<int>> CountLikes([FromQuery] int postId)
    {
        try
        {
            int count = await userLogic.CountLikesAsync(postId);
            return Ok(count);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}