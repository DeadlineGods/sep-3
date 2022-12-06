using System;
using System.Collections.Generic;
using System.Globalization;
using System.Threading.Tasks;
using Application.DAOsInterfaces;
using Domain.DTOs;
using Domain.Models;
using Grpc.Net.Client;
using GrpcClient;
using Post = Domain.Models.Post;

namespace Application.GrpcClients;

public class PostGrpcClient : IPostDao
{
	private readonly IUserDao userDao;
	private readonly ILocationDao locationDao;

	public PostGrpcClient(IUserDao userDao, ILocationDao locationDao)
	{
		this.userDao = userDao;
		this.locationDao = locationDao;
	}

    public async Task<long> CreateAsync(PostCreationDto post)
    {
	    using var channel = GrpcChannel.ForAddress("http://localhost:6565");
	    var client = new PostService.PostServiceClient(channel);

	    var request = new RequestCreatePost
	    {
		    Title = post.Title,
		    Description = post.Description,
		    UserId = post.UserId,
			ImgUrl = post.ImgUrl,
			LocationId = post.LocationId
	    };
	    

	    var reply = await client.CreatePostAsync(request);

	    return await Task.FromResult(reply.Id);
    }

    public async Task<IEnumerable<Post>> GetAsync(SearchPostParametersDto parametersDto)
    {
	    using var channel = GrpcChannel.ForAddress("http://localhost:6565");
	    var client = new PostService.PostServiceClient(channel);
	    var reply = await client.GetPostAsync(
		    new RequestGetPost
		    {
			    Id = parametersDto.Id ?? 0,
			    UserId = parametersDto.UserId ?? 0,
			    Title = parametersDto.TitleContains ?? ""
		    });

	    IList<Post> posts = new List<Post>();
	    foreach (var replyPost in reply.Posts)
	    {
			posts.Add(await ConstructPostAsync(replyPost));
	    }

	    return await Task.FromResult(posts);

    }

    public async Task DeleteAsync(long id)
    {
	    using var channel = GrpcChannel.ForAddress("http://localhost:6565");
	    var client = new PostService.PostServiceClient(channel);
	    try
	    {
			await client.DeletePostAsync(
		    new RequestDeletePost
		    {
			    Id = id
		    });
	    }
	    catch (Exception e)
	    {
		    Console.WriteLine(e);
		    throw;
	    }

	    await Task.CompletedTask;
    }


    

    public async Task UpdateAsync(Post post)
    {
	    using var channel = GrpcChannel.ForAddress("http://localhost:6565");
	    var client = new PostService.PostServiceClient(channel);
	    try
	    {
		    
		    RequestUpdatePost request = new RequestUpdatePost
		    {
			    Id = (int)post.Id,
			    Title = post.Title,
			    Description = post.Description,
		    };
		    foreach (var tag in request.Tags)
		    {
			    Console.WriteLine(tag);
			    request.Tags.Add(tag);
		    }
		    
		    await client.UpdatePostAsync(request);
	    }
	    catch (Exception e)
	    {
		    Console.WriteLine(e);
		    throw;
	    }

	    await Task.CompletedTask;
    }

 

    private async Task<Post> ConstructPostAsync(PostData reply)
    {
	    TimeSpan time = TimeSpan.FromMilliseconds(reply.PostedOnMilliseconds);
	    DateTime postedOn = new DateTime(1970, 1, 1) + time;
	    SearchUserParametersDto dto = new SearchUserParametersDto(null, reply.UserId);
	    IEnumerable<User> users = await userDao.GetAsync(dto);
	    Location location = await locationDao.GetAsync(reply.LocationId);
	    
	    return new Post(reply.Id, users.FirstOrDefault(), reply.Likes, reply.Title, reply.ImgUrl, reply.Description, postedOn, location);
    }
    
 
}
