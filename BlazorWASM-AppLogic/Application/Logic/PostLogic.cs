using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System;
using System.Threading.Tasks;
using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class PostLogic : IPostLogic
{
    private readonly IPostDao postDao;
    private readonly IUserDao userDao;

    public PostLogic(IPostDao postDao, IUserDao userDao)
    {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    public async Task<int> CreateAsync(PostCreationDto postCreationDto)
    {
        ValidatePost(postCreationDto);

        SearchUserParametersDto dto = new SearchUserParametersDto(null, postCreationDto.UserId);
        IEnumerable<User> users = await userDao.GetAsync(dto);
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

        return await postDao.CreateAsync(post);
    }

    public async Task<IEnumerable<Post>> GetAsync(SearchPostParameters parameters)
    {
	    return await postDao.GetAsync(parameters);
    }

    public async Task DeleteAsync(int id)
    {
        await postDao.DeleteAsync(id);
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
