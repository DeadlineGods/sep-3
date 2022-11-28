using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IUserService
{
    Task<User> CreateAsync(UserAuthDto dto);
    Task<IEnumerable<User>> GetUsersAsync(string? usernameContains, long? userid);
}