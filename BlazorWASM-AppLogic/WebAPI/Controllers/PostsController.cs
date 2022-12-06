using System;
using System.Collections.Generic;
using System.Threading.Tasks;
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
            long id = await postLogic.CreateAsync(postCreationDto);
            return Ok(id);
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
	    [FromQuery] long? id,
	    [FromQuery] long? userId,
	    [FromQuery] string? titleContains
	)
    {
		try
	    {
		    SearchPostParametersDto parametersDto = new SearchPostParametersDto(id, userId, titleContains);
            IEnumerable<Post> posts = await postLogic.GetAsync(parametersDto);
            return Ok(posts);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    [HttpGet, Route("getInRadius")]
    public async Task<ActionResult<Post>> GetInRadiusAsync([FromQuery] double lat, [FromQuery] double lon, [FromQuery] int radius)
    {
	    try
	    {
		    IEnumerable<Post> posts = await postLogic.GetInRadiusAsync(new Coordinate(lat, lon), radius);
		    return Ok(posts);
	    }
	    catch (Exception e)
	    {
		    Console.WriteLine(e);
		    return StatusCode(500, e.Message);
	    }
    }


    [HttpDelete ("{id:int}")]
    public async Task<ActionResult> DeleteAsync([FromRoute] long id)
    {
        try
        {
            await postLogic.DeleteAsync(id);
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

}
