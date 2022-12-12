using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class TagController:ControllerBase
{
    private readonly ITagLogic tagLogic;

    public TagController(ITagLogic tagLogic)
    {
        this.tagLogic = tagLogic;
    }
    
    /// <summary>
    /// Returns a newly created TagPost.
    /// </summary>
    /// <param name="dto">Dto contains postId and list of tags. All of the parameters are mandatory.</param>
    /// <returns></returns>
    [HttpPost, Route("create")]
    public async Task<ActionResult<TagPost>> CreateAsync(PostTagCreationDto dto)
    {
        try
        {
            string[] tagsArray = await tagLogic.CreateAsync(dto);
            return Ok(tagsArray);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    /// <summary>
    /// Returns a list of TagPosts from a given post id, with filter.
    /// If all of the parameters are null end point returns all of the TagPosts
    /// </summary>
    /// <param name="TagContains">It is optional.</param>
    /// <param name="postId">It is optional.</param>
    /// <returns></returns>
    [HttpGet,Route("getPostTag")]
    public async Task<ActionResult<IEnumerable<TagPost>>> GetPostTagAsync
    (
        [FromQuery] string? TagContains,
        [FromQuery] long? postId
    ) {
        try
        {
            SearchPostTagParameters parameters = new SearchPostTagParameters(TagContains, postId);
            IEnumerable<TagPost> tags = await tagLogic.GetPostTagAsync(parameters);
            return Ok(tags);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    /// <summary>
    /// Returns a list of Tags a with filter.
    /// If the parameter is null the end point returns all of the tags /// </summary>
    /// <param name="TagContains">It is optional.</param>
    /// <returns></returns>
    [HttpGet,Route("getTagList")]
    public async Task<ActionResult<Tag>> GetTagListAsync
    (
        [FromQuery] string? TagContains
    ) {
        try
        {
            SearchTagListParameters parameters = new SearchTagListParameters(TagContains);
            IEnumerable<Tag> tags = await tagLogic.GetTagListAsync(parameters);
            
            return Ok(tags);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    /// <summary>
    /// Deletes all tags from specified post id.
    /// </summary>
    /// <param name="postId"></param>
    /// <returns></returns>
    [HttpDelete("{postId:int}")]
    public async Task<ActionResult> DeleteAsync([FromRoute] long postId)
    {
        try
        {
            await tagLogic.DeleteTask(postId);
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}