using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class PostLogic : IPostLogic
{
    private readonly IPostDao postDao;

    public PostLogic(IPostDao postDao)
    {
        this.postDao = postDao;
    }
    
    public async Task<Post> CreateAsync(PostCreationDto postCreationDto)
    {
        ValidatePost(postCreationDto);

        Post post = new Post(postCreationDto.likes,postCreationDto.title,postCreationDto.description);
        
        return await postDao.CreateAsync(post);
    }

    private void ValidatePost(PostCreationDto postCreationDto)
    {
        throw new NotImplementedException();
    }
}