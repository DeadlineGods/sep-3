using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class PostsController : ControllerBase
{
    private readonly IPostLogic postLogic;

    public PostsController(IPostLogic postLogic)
    {
        this.postLogic = postLogic;
    }

    [HttpPost, Route("create")]
    public async Task<ActionResult<Post>> CreateAsync(PostCreationDto postCreationDto)
    {
	    try
        {
            Post post = await postLogic.CreateAsync(postCreationDto);
            return Created($"/posts/{post.title}", post);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }


    [HttpGet, Route("get")]
    public async Task<ActionResult<Post>> GetAsync
    (
	    [FromQuery] int? id,
	    [FromQuery] int? userId,
	    [FromQuery] string? titleContains
	) {
	    try
	    {
		    SearchPostParameters parameters = new SearchPostParameters(id, userId, titleContains);
            IEnumerable<Post> posts = await postLogic.GetAsync(parameters);
            return Ok(posts);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }


}
