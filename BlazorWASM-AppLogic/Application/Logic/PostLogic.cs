
using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class PostLogic : IPostLogic
{
    private readonly IPostDao PostDao;
    private readonly IUserDao UserDao;
    private readonly ILikeDao LikeDao;

    public PostLogic(IPostDao postDao, IUserDao userDao, ILikeDao likeDao)
    {
       PostDao = postDao;
       UserDao = userDao;
       LikeDao = likeDao;
    }

    public async Task<int> CreateAsync(PostCreationDto postCreationDto)
    {
        ValidatePost(postCreationDto);

        SearchUserParametersDto dto = new SearchUserParametersDto(null, postCreationDto.UserId);
        IEnumerable<User> users = await UserDao.GetAsync(dto);
        User existingOwner = users.FirstOrDefault();
        if (existingOwner == null)
        {
            throw new Exception($"User with id = {postCreationDto.UserId} does not exist");
        }

        Post post = new Post()
        {
            Title = postCreationDto.Title,
            Description = postCreationDto.Description,
            Tags = postCreationDto.Tags,
            Owner = existingOwner,
            ImgUrl = postCreationDto.ImgUrl,
            Coordinate = postCreationDto.Coordinates
        };

        return await PostDao.CreateAsync(post);
    }

    public async Task<IEnumerable<Post>> GetAsync(SearchPostParametersDto parametersDto)
    {
        IEnumerable<Post> posts = await PostDao.GetAsync(parametersDto);
        foreach (var post in posts)
        {
            post.Likes = await LikeDao.CountLikesAsync(post.Id);
        }

        return posts;
    }

    public async Task DeleteAsync(int id)
    {
        await PostDao.DeleteAsync(id);
    }

    private void ValidatePost(PostCreationDto postCreationDto)
    {
        if (postCreationDto.Description.Length > 5000)
        {
            throw new Exception("Description has more characters than 5000");
        }

        if (postCreationDto.Title.Length > 150)
        {
            throw new Exception("Title has more characters than 150");
        }
    }
}
