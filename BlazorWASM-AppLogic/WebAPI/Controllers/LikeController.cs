using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class LikeController : ControllerBase
{
    private readonly ILikeLogic likeLogic;
    
    public LikeController(ILikeLogic likeLogic)
    {
        this.likeLogic = likeLogic;
    }
    
    /// <summary>
    /// Returns how many likes a post has with a given id.
    /// </summary>
    /// <param name="postId"></param>
    /// <returns></returns>
    [HttpGet, Route("likes")]
    public async Task<ActionResult<int>> CountLikesAsync([FromQuery] int postId)
    {
        try
        {
            int count = await likeLogic.CountLikesAsync(postId);
            return Ok(count);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    /// <summary>
    /// Returns a boolean is post liked, true = is liked, false = not liked.
    /// </summary>
    /// <param name="postId"></param>
    /// <param name="userId"></param>
    /// <returns></returns>
    [HttpGet, Route("is-liked")]
    public async Task<ActionResult<bool>> IsPostLikedAsync([FromQuery] int postId, [FromQuery] long userId)
    {
        try
        {
            IsPostLikedDto dto = new(postId, userId);
            bool isPostLiked = await likeLogic.IsPostLikedAsync(dto);
            return Ok(isPostLiked);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    /// <summary>
    /// Unlikes the post.
    /// </summary>
    /// <param name="dto">Dto contains postId, userId. All parameters are mandatory.</param>
    /// <returns></returns>
    [HttpPost, Route("unlike")]
    public async Task<ActionResult> UnlikePostAsync([FromBody] UnLikePostDto dto)
    {
        try
        { 
            await likeLogic.UnLikePostAsync(dto);
            return Ok();
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
    
    /// <summary>
    /// Likes the post.
    /// </summary>
    /// <param name="">Dto contains postId, userId. All parameters are mandatory.</param>
    /// <returns></returns>
    [HttpPost, Route("like")]
    public async Task<ActionResult<Like>> LikePostAsync([FromBody] LikePostDto dto)
    {
        try
        {
            Like like = await likeLogic.LikePostAsync(dto);
            return Created($"/likes/{like.likedBy}&{like.likedPost}", like);
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            return StatusCode(500, e.Message);
        }
    }
}