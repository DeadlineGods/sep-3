using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class UserController : ControllerBase
{
    public UserController()
    {
        
    }

    [HttpPost]
    public async Task<ActionResult<User>> CreateAsync(UserCreationDto userCreationDto)
    {
        try
        {
            User user = null;
            return Created($"/users/{user.userName}", user);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }
    }
}