namespace Application.DAOsInterfaces;

public class PostGrpcClient : IPostDao
{
    public Task<Post> CreateAsync(Post post)
    {
        throw new NotImplementedException();
    }
}