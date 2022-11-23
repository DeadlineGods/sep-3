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

    public PostLogic(IPostDao postDao)
    {
        this.postDao = postDao;
    }

    public async Task<Post> CreateAsync(PostCreationDto postCreationDto)
    {
        ValidatePost(postCreationDto);

        Post post = new Post()
        {
            title = postCreationDto.title,
            description = postCreationDto.description,
            tags = postCreationDto.tags
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
        if (postCreationDto.description.Length > 5000)
        {
            throw new Exception("Description has more characters than 5000");
        }

        if (postCreationDto.title.Length > 150)
        {
            throw new Exception("Title has more characters than 150");
        }
    }
}
