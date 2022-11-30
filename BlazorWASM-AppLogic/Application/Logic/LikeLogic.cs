using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class LikeLogic : ILikeLogic
{
    private readonly IUserDao UserDao;
    private readonly IPostDao PostDao;
    private readonly ILikeDao LikeDao;

    public LikeLogic(IUserDao userDao, IPostDao postDao, ILikeDao likeDao)
    {
        UserDao = userDao;
        PostDao = postDao;
        LikeDao = likeDao;
    }
    
    public async Task<Like> LikePostAsync(LikePostDto dto)
    {
        if (!await CheckIfPostExistsAsync(dto.postId))
        {
            throw new Exception($"Post with id={dto.postId} does not exist");
        }
		
        if (!await CheckIfUserExistsAsync(dto.userId))
        {
            throw new Exception($"User with id={dto.userId} does not exist");
        }

        Like likePost = await LikeDao.LikePostAsync(dto);
		
        return likePost;
    }

    public async Task UnLikePostAsync(UnLikePostDto unLikePostDto)
    {
        if (!await CheckIfPostExistsAsync(unLikePostDto.postId))
        {
            throw new Exception($"Post with id={unLikePostDto.postId} does not exist");
        }
		
        if (!await CheckIfUserExistsAsync(unLikePostDto.userId))
        {
            throw new Exception($"User with id={unLikePostDto.userId} does not exist");
        }

        await LikeDao.UnLikePostAsync(unLikePostDto);
    }

    public async Task<bool> IsPostLikedAsync(IsPostLikedDto isPostLikedDto)
    {
        if (!await CheckIfPostExistsAsync(isPostLikedDto.postId))
        {
            throw new Exception($"Post with id={isPostLikedDto.postId} does not exist");
        }
		
        if (!await CheckIfUserExistsAsync(isPostLikedDto.userId))
        {
            throw new Exception($"User with id={isPostLikedDto.userId} does not exist");
        }

        return await LikeDao.IsPostLikedAsync(isPostLikedDto);
    }

    public async Task<int> CountLikesAsync(int postId)
    {
        int count = 0;
        try
        {
            count = await LikeDao.CountLikesAsync(postId);
        }
        catch (Exception e)
        {
            Console.WriteLine("Not found");
            throw;
        }

        return count;
    }
    
    private async Task<bool> CheckIfPostExistsAsync(int id)
    {
        SearchPostParametersDto searchPostParametersDto = new(id, null, null);
        IEnumerable<Post> existingPosts = await PostDao.GetAsync(searchPostParametersDto);
        Post? existingPost = existingPosts.FirstOrDefault();

        return existingPost != null;
    }

    private async Task<bool> CheckIfUserExistsAsync(long id)
    {
        SearchUserParametersDto searchUserParametersDto = new(null, id);
        IEnumerable<User> existingUsers = await UserDao.GetAsync(searchUserParametersDto);
        User? existingUser = existingUsers.FirstOrDefault();

        return existingUser != null;
    }
}