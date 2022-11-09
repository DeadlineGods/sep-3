using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IPostService
{
    Task CreateAsync(PostCreationDto postCreationDto);
    Task<ICollection<Post>> GetAsync(int? id, int? userId, string? titleContains);
    Task DeleteAsync(int id);
}
