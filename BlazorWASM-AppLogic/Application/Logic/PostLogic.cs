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
using SearchPostParameters = Domain.DTOs.SearchPostParametersDto;

namespace Application.Logic;

public class PostLogic : IPostLogic
{
    private readonly IPostDao PostDao;
    private readonly IUserDao UserDao;
    private readonly ILikeDao LikeDao;
    private readonly ILocationDao LocationDao;

    public PostLogic(IPostDao postDao, IUserDao userDao, ILikeDao likeDao, ILocationDao locationDao)
    {
       PostDao = postDao;
       UserDao = userDao;
       LikeDao = likeDao;
       LocationDao = locationDao;
    }

    public async Task<long> CreateAsync(PostCreationDto postCreationDto)
    {
        ValidatePost(postCreationDto);

        SearchUserParametersDto dto = new SearchUserParametersDto(null, postCreationDto.UserId);
        IEnumerable<User> users = await UserDao.GetAsync(dto);
        User existingOwner = users.FirstOrDefault();
        if (existingOwner == null)
        {
            throw new Exception($"User with id = {postCreationDto.UserId} does not exist");
        }

        return await PostDao.CreateAsync(postCreationDto);
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



    public async Task DeleteAsync(long post_id, int user_id)
    {
        SearchPostParametersDto parameters = new SearchPostParametersDto(post_id);
        IEnumerable<Post> posts = await GetAsync(parameters);
        foreach (var post in posts)
        {
            if (post.Owner.Id == user_id)
            {
                await PostDao.DeleteAsync(post_id);
            }
        }
        
        await PostDao.DeleteAsync(post_id);
    }

    public async Task<IEnumerable<Post>> GetInRadiusAsync(Coordinate center, int radius)
    {
	    IEnumerable<Post> posts = await GetAsync(new SearchPostParametersDto());
	    ICollection<Post> postsInRadius = new List<Post>();


	    foreach (Post post in posts)
	    {
		    if (IsInRadius(center, post.Location.coordinate, radius))
			    postsInRadius.Add(post);
	    }

	    return postsInRadius;

    }

    private bool IsInRadius(Coordinate center, Coordinate postCoordinate, int radius)
    {
	    // formula
	    //d = √[(x₂ - x₁)² + (y₂ - y₁)²]

	    double R = 6378.137; // Radius of earth in KM
	    double dLat = center.latitude * Math.PI / 180 - postCoordinate.latitude * Math.PI / 180;
	    double dLon = center.longitude * Math.PI / 180 - postCoordinate.longitude * Math.PI / 180;
	    double a = Math.Sin(dLat/2) * Math.Sin(dLat/2) +
	            Math.Cos(center.latitude * Math.PI / 180) * Math.Cos(postCoordinate.latitude * Math.PI / 180) *
	            Math.Sin(dLon/2) * Math.Sin(dLon/2);
	    double c = 2 * Math.Atan2(Math.Sqrt(a), Math.Sqrt(1-a));
	    double d = R * c;


	    return d * 1000 < radius;
    }

    

    public async Task<int> UpdateAsync(UpdatePostDto dto, int user_id)
    {
        

        SearchPostParametersDto postParameters = new SearchPostParametersDto(dto.Id);
        IEnumerable<Post> posts = await PostDao.GetAsync(postParameters);
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
            await PostDao.UpdateAsync(updated);
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
