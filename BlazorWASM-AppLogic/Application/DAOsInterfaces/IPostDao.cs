namespace Application.DAOsInterfaces;

public interface IPostDao
{
    Task<Post> CreateAsync(Post post);
}