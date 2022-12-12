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
    
    /// <summary>
    /// Returns a id of a created comment.
    /// </summary>
    /// <param name="creationDto">Dto contains OwnerId, PostId, Body (comment text). All the parameters are mandatory.</param>
    /// <returns></returns>
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
    
    /// <summary>
    /// Assigns a sub comment to a parent comment.
    /// </summary>
    /// <param name="assignCommentToDto">Dto contains commentId (sub comment id), parentId. All of the parameters are mandatory.</param>
    /// <returns></returns>
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
    
    /// <summary>
    /// Returns a list of only comments that are root comments from a post (they do not have a parent comment).
    /// </summary>
    /// <param name="postId"></param>
    /// <returns></returns>
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
    
    /// <summary>
    /// Returns a list of comments only that have a parent comment with a given id. Example all sub comments of a comment with id = 5.
    /// </summary>
    /// <param name="id"></param>
    /// <returns></returns>
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

    /// <summary>
    /// Returns a single comment by the id.
    /// </summary>
    /// <param name="id"></param>
    /// <returns></returns>
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



