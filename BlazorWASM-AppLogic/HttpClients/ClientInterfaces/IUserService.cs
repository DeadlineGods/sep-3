using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IUserService
{
    Task<User> Create(UserAuthDto dto);
    Task<IEnumerable<User>> GetUsers(string? usernameContains = null);
}