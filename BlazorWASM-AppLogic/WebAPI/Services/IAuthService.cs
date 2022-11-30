using Domain.DTOs;
using Domain.Models;

namespace WebAPI.Services;

public interface IAuthService
{
    Task<User> ValidateUserAsync(string username, string password);

    //Not used now
    //Task<User> GetUser(string username, string password);
    Task<User> RegisterUserAsync(UserCreationDto creationDto);
}
