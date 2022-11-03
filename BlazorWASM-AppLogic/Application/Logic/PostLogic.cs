﻿using Application.DAOsInterfaces;
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
            description = postCreationDto.title,
        };
        
        return await postDao.CreateAsync(post);
    }

    private void ValidatePost(PostCreationDto postCreationDto)
    {
        if (postCreationDto.description.Length > 5000)
        {
            throw new Exception("Description has more characters than 5000");
        }
        
        if (postCreationDto.title.Length > 150)
        {
            throw new Exception("Description has more characters than 150");
        }
    }
}