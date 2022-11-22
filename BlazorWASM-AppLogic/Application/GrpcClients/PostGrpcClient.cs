using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Application.DAOsInterfaces;
using Domain.DTOs;
using Grpc.Net.Client;
using GrpcClient;
using Post = Domain.Models.Post;

namespace Application.GrpcClients;

public class PostGrpcClient : IPostDao
{
    public async Task<Post> CreateAsync(Post post)
    {
	    using var channel = GrpcChannel.ForAddress("http://localhost:6565");
	    var client = new PostService.PostServiceClient(channel);
	    var reply = await client.CreatePostAsync(
		    new RequestCreatePost
		    {
			    Title = post.title,
			    Description = post.description
		    });

	    return await Task.FromResult(CreatePost(reply));

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
			posts.Add(CreatePost(replyPost));
	    }

	    return await Task.FromResult(posts);

    }

    private Post CreatePost(GrpcClient.Post reply)
    {
	    TimeSpan time = TimeSpan.FromMilliseconds(reply.PostedOnMilliseconds);
	    DateTime postedOn = new DateTime(time.Ticks);

	    Post replyPost = new Post(reply.Id, reply.Likes, reply.Title, reply.Description, postedOn);

	    return await Task.FromResult(replyPost);

    }

    public async Task<IEnumerable<Post>> GetAsync(SearchPostParameters parameters)
    {
	    throw new NotImplementedException();
    }

    public async Task DeleteAsync(int id)
    {
	    using var channel = GrpcChannel.ForAddress("http://localhost:6565");
	    var client = new GrpcClient.Post.PostClient(channel);
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
}
