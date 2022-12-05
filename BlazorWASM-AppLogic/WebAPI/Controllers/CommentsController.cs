using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class CommentsController :  ControllerBase
{
    private readonly ICommentLogic commentLogic;

    public CommentsController(ICommentLogic commentLogic)
    {
        this.commentLogic = commentLogic;
    }
    
    [HttpPost]
    public async Task<ActionResult<long>> CreateAsync([FromBody] CommentCreationDto creationDto)
    {
        try
        {
            long commentId = await commentLogic.CreateAsync(creationDto);
            return Created($"/comments/{commentId}", commentId);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    [HttpPost, Route("/assign")]
    public async Task<ActionResult> AssignCommentToParentAsync([FromBody] AssignCommentToDto assignCommentToDto)
    {
        try
        {
             await commentLogic.AssignCommentToParentAsync(assignCommentToDto);
             return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    [HttpGet]
    public async Task<ActionResult<IEnumerable<Comment>>> GetAsync([FromQuery] long postId)
    {
        try
        {
            IEnumerable<Comment> comments = await commentLogic.GetAsync(postId);
            return Ok(comments);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    [HttpGet]
    [Route("/sub-comments/")]

    public async Task<ActionResult<IEnumerable<Comment>>> GetSubCommentsAsync([FromQuery] long id)
    {
        try
        {
            IEnumerable<Comment> comments = await commentLogic.GetSubCommentsAsync(id);
            return Ok(comments);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }

    [HttpGet]
    [Route("/comment/")]
    public async Task<ActionResult<Comment>> GetByIdAsync([FromQuery] long id)
    {
        try
        {
            Comment comment = await commentLogic.GetByIdAsync(id);
            return Ok(comment);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
}



