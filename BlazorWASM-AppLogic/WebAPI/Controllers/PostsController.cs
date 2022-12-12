using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Geocoding;
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

    /// <summary>
    /// Returns a newly created post.
    /// </summary>
    /// <param name="postCreationDto">Dto contains Title, Description, UserId, ImgUrl, LocationId. All of the parameters are mandatory.</param>
    /// <returns></returns>
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

    /// <summary>
    /// Returns a post by search parameters. If none of the search parameters are specified end point returns all of the posts.
    /// </summary>
    /// <param name="id">If the "id" is null, it will not be applied as a filter.</param>
    /// <param name="userId">If the "userId" is null, it will not be applied as a filter.</param>
    /// <param name="titleContains">If the "titleContains" is null, it will not be applied as a filter.</param>
    /// <returns></returns>
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

    /// <summary>
    /// Returns a list of posts that are in radius of a given location. Example return all posts in radius = 10km at the location latitude = 55.8547202, longitude = 9.7687163. 
    /// </summary>
    /// <param name="lat">Latitude.</param>
    /// <param name="lon">Longitude.</param>
    /// <param name="radius">Must be in kilometres.</param>
    /// <returns></returns>
    [HttpGet, Route("getInRadius")]
    public async Task<ActionResult<IEnumerable<Post>>> GetInRadiusAsync([FromQuery] double lat, [FromQuery] double lon, [FromQuery] int radius)
    {
	    try
	    {
		    IEnumerable<Post> posts = await postLogic.GetInRadiusAsync(new Coordinate(lat, lon), radius);
            Console.WriteLine(lat);
		    return Ok(posts);
	    }
	    catch (Exception e)
	    {
		    Console.WriteLine(e);
		    return StatusCode(500, e.Message);
	    }
    }
    
    /// <summary>
    /// Deletes a post with given id. UserId parameter check if the user who wants to delete is the owner.
    /// </summary>
    /// <param name="id"></param>
    /// <param name="user_id"></param>
    /// <returns></returns>
    [HttpDelete("{id:int}")]
    public async Task<ActionResult> DeleteAsync([FromRoute] long id,[FromQuery] int user_id)
    {
        try
        {
            await postLogic.DeleteAsync(id, user_id);
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    /// <summary>
    /// Updating a given post. UserId parameter check if the user who wants to update is the owner.
    /// </summary>
    /// <param name="dto">Dto contains Id, Title, Description, list of tags.
    /// Only Id and tags list are mandatory.
    /// Title and description are not mandatory and if they are null they will be skipped.</param>
    /// <param name="user_id"></param>
    /// <returns></returns>
    [HttpPatch]
    public async Task<ActionResult> UpdateAsync([FromBody] UpdatePostDto dto, [FromQuery] int user_id)
    {
        try
        {
            await postLogic.UpdateAsync(dto, user_id);
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}
