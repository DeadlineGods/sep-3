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

    /// <summary>
    /// Returns a newly created user.
    /// </summary>
    /// <param name="userCreationDto">Dto contains username, password, firstName, lastName, email, phoneNumber, locationId. All of the parameters are mandatory.</param>
    /// <returns></returns>
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
    
    /// <summary>
    /// Returns a list of user based on search parameters. If all of the parameters are null end point will return all of the users.
    /// </summary>
    /// <param name="username">if "username" is null the filter will not be applied.</param>
    /// <param name="userId">if "userId" is null the filter will not be applied.</param>
    /// <returns></returns>
    [HttpGet]
    public async Task<ActionResult<IEnumerable<User>>> GetAsync
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
    
    /// <summary>
    /// Returns a list of users who liked the post.
    /// </summary>
    /// <param name="postId"></param>
    /// <returns></returns>
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
}