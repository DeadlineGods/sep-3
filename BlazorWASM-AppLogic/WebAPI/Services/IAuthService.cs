using Domain.Models;

namespace WebAPI.Services;

public interface IAuthService
{
    Task<User> ValidateUser(string username, string password);

    //Not used now
    
    //Task<User> GetUser(string username, string password);
    //Task RegisterUser(User user);
}