using Domain.DTOs;
using Domain.Models;

namespace WebAPI.Services;

public interface IAuthService
{
    Task<LoginDto> ValidateUserAsync(string username, string password);
    Task<User> RegisterUserAsync(UserCreationDto creationDto);
    Task<LoginDto> ValidateAdminAsync(string username, string password);
}
