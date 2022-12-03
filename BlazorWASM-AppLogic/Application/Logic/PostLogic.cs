using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System;
using System.Threading.Tasks;
using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using SearchPostParameters = Domain.DTOs.SearchPostParameters;

namespace Application.Logic;

public class PostLogic : IPostLogic
{
    private readonly IPostDao postDao;
    private readonly IUserDao userDao;
    private readonly ILocationDao locationDao;

    public PostLogic(IPostDao postDao, IUserDao userDao, ILocationDao locationDao)
    {
        this.postDao = postDao;
        this.userDao = userDao;
        this.locationDao = locationDao;
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

    public async Task<IEnumerable<Post>> GetInRadiusAsync(Coordinate center)
    {
	    IEnumerable<Post> posts = await GetAsync(new SearchPostParameters());
	    ICollection<Post> postsInRadius = new List<Post>();

	    foreach (Post post in posts)
	    {
		    Coordinate coordinates = await locationDao.GetCoordinatesAsync(post.Id);

		    if (IsInRadius(center, coordinates))
			    postsInRadius.Add(post);
	    }

	    return postsInRadius;

    }

    private bool IsInRadius(Coordinate center, Coordinate postCoordinate)
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

	    return d * 1000 < 30000;
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
