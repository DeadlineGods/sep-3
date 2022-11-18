using System.ComponentModel.DataAnnotations;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain;
using Domain.Models;

namespace WebAPI.Services;

public class AuthService : IAuthService
{
    private readonly IUserLogic userLogic;
    private IList<User> users;

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
}