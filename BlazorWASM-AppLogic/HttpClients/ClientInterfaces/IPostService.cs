using System.Collections.Generic;
using System.Threading.Tasks;
using System.Threading.Tasks;
using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IPostService
{
    Task CreateAsync(PostCreationDto postCreationDto);
    Task<ICollection<Post>> GetAsync(int? id = null, int? userId = null, string? titleContains = null);
    Task DeleteAsync(int id);
}
