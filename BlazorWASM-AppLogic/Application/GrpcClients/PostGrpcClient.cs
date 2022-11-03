using Domain.Models;

namespace Application.DAOsInterfaces;

public class PostGrpcClient : IPostDao
{
    public Task<Post> CreateAsync(Post post)
    {
        return Task.FromResult<Post>(post);
    }
}