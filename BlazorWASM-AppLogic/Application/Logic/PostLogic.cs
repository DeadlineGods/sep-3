using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System;
using System.Collections;
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
            Owner = existingOwner
        };

        return await postDao.CreateAsync(post);
    }

    public async Task<IEnumerable<Post>> GetAsync(SearchPostParameters parameters)
    {
        IEnumerable<Post> posts = await postDao.GetAsync(parameters);
        foreach (var post in posts)
        {
            post.Likes = await userDao.CountLikesAsync(post.Id);
        }

        return posts;
    }



    public async Task DeleteAsync(int post_id, int user_id)
    {
        SearchPostParameters parameters = new SearchPostParameters(post_id);
        IEnumerable<Post> posts = await GetAsync(parameters);
        foreach (var post in posts)
        {
            if (post.Owner.Id == user_id)
            {
                await postDao.DeleteAsync(post_id);
            }
        }
        
    }

    

    public async Task<int> UpdateAsync(UpdatePostDto dto, int user_id)
    {
        

        SearchPostParameters postParameters = new SearchPostParameters(dto.Id);
        IEnumerable<Post> posts = await postDao.GetAsync(postParameters);
        Post? existing = posts.FirstOrDefault();
        if (existing == null)
        {
            throw new Exception($"Post with {dto.Id} not found");
        }

        Console.WriteLine(existing.Owner.Id);
        Console.WriteLine(user_id);
        
        if (existing.Owner.Id == user_id)
        {
            string titleToUse = dto.Title ?? existing.Title;
            string descriptionToUse = dto.Description ?? existing.Description;
            //IList<string> tags = dto.Tags ?? existing.Tags;
            
            
            Post updated = new Post()
            {
                Id = dto.Id,
                Title = titleToUse,
                Description = descriptionToUse,
                Tags = dto.Tags,
                Owner = existing.Owner
            };
            Console.WriteLine(updated.Title);
            ValidatePost(updated);
            await postDao.UpdateAsync(updated);
        }
        

        return dto.Id;
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
    
    private void ValidatePost(Post dto)
    {
        if (dto.Description.Length > 5000)
        {
            throw new Exception("Description has more characters than 5000");
        }

        if (dto.Title.Length > 150)
        {
            throw new Exception("Title has more characters than 150");
        }
    }
}
