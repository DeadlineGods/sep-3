using System.ComponentModel.DataAnnotations;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain;
using Domain.Models;
using HttpClients.ClientInterfaces;
using HttpClients.Implementations;

namespace WebAPI.Services;

public class AuthService : IAuthService
{
    private readonly IUserLogic userLogic;
    private IEnumerable<User> users;
    private IUserService userService = new UserHttpClient(new HttpClient());

    public AuthService(IUserLogic userLogic)
    {
        this.userLogic = userLogic;
        users = new List<User>();
    }

    private async void LoadUsersIntoList()
    {
        SearchUserParametersDto dto = new SearchUserParametersDto(null);
        IEnumerable<User> tempUsers = await userLogic.GetAsync(dto);
        users = tempUsers.ToList();
    }

    public Task<User> ValidateUser(string username, string password)
    {
        LoadUsersIntoList();
        User? existingUser = users.FirstOrDefault(user =>
            user.userName.Equals(username, StringComparison.OrdinalIgnoreCase));

        if (existingUser == null)
        {
            throw new Exception("User not found");
        }

        if (!existingUser.password.Equals(password))
        {
            throw new Exception("Password mismatch");
        }
        return Task.FromResult(existingUser);
    }

    public async Task<User> RegisterUser(UserCreationDto dto)
    {
        users = await userService.GetUsers();

        if (string.IsNullOrEmpty(dto.userName))
        {
            throw new ValidationException("Username cannot be null");
        }

        if (string.IsNullOrEmpty(dto.password))
        {
            throw new ValidationException("Password cannot be null");
        }

        User? existingUser = users.FirstOrDefault(u =>
            u.userName.Equals(dto.userName, StringComparison.OrdinalIgnoreCase));

        if (existingUser != null)
        {
            throw new Exception("This username is taken");
        }

     
        return await userService.Create(new UserAuthDto(dto.userName,dto.fullName,dto.password,dto.email,dto.phoneNumber));
    }
}