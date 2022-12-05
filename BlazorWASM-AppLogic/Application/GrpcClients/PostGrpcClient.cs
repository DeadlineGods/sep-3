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

    public async Task<int> CreateAsync(PostCreationDto post)
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

	    //add tags
	    foreach (var tag in post.Tags)
	    {
		    request.Tags.Add(tag);
	    }

	    var reply = await client.CreatePostAsync(request);

	    return await Task.FromResult(reply.Id);
    }

    public async Task<IEnumerable<Post>> GetAsync(SearchPostParameters parameters)
    {
	    using var channel = GrpcChannel.ForAddress("http://localhost:6565");
	    var client = new PostService.PostServiceClient(channel);
	    var reply = await client.GetPostAsync(
		    new RequestGetPost
		    {
			    Id = parameters.Id ?? 0,
			    UserId = parameters.UserId ?? 0,
			    Title = parameters.TitleContains ?? ""
		    });

	    IList<Post> posts = new List<Post>();
	    foreach (var replyPost in reply.Posts)
	    {
			posts.Add(await ConstructPostAsync(replyPost));
	    }

	    return await Task.FromResult(posts);

    }

    public async Task DeleteAsync(int id)
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
