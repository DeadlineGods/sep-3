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
    
    [HttpGet,Route("get")]
    public async Task<ActionResult<Tag>> GetPostTagAsync
    (
        [FromQuery] string? TagContains,
        [FromQuery] int? postId
    ) {
        try
        {
            SearchPostTagParameters parameters = new SearchPostTagParameters(TagContains, postId);
            IEnumerable<Tag> tags = await tagLogic.GetPostTagAsync(parameters);
            return Ok(tags);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}