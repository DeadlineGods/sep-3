using Application.DAOsInterfaces;
using Grpc.Net.Client;
using GrpcClient;
using Post = Domain.Models.Post;

namespace Application.GrpcClients;

public class PostGrpcClient : IPostDao
{
    public async Task<Post> CreateAsync(Post post)
    {
	    using var channel = GrpcChannel.ForAddress("http://localhost:6565");
	    var client = new GrpcClient.Post.PostClient(channel);
	    var reply = await client.CreatePostAsync(
		    new RequestCreatePost
		    {
			    Title = "Hello there",
			    Description = "Working"
		    });

	    Console.WriteLine(reply.Title);
	    return null;

    }
}
