using System.Collections.Generic;
using System.Threading.Tasks;
using System.Threading.Tasks;
using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IPostService
{
    Task<int> CreateAsync(PostCreationDto postCreationDto);
    Task<ICollection<Post>> GetAsync(long? id = null, long? userId = null, string? titleContains = null);
    Task DeleteAsync(long id);
    Task<IEnumerable<Post>> GetInRadiusAsync(Coordinate coordinate, int radius);
}
