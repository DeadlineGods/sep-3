using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface IPostDao
{
    Task<Post> CreateAsync(Post post);
    Task<IEnumerable<Post>> GetAsync(SearchPostParameters parameters);
}
