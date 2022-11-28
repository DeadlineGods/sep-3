using System.ComponentModel.DataAnnotations;
using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain;
using Domain.Models;
using HttpClients.ClientInterfaces;
using HttpClients.Implementations;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Services;


public class AuthService : IAuthService
{
    private readonly IUserLogic userLogic;
    private IEnumerable<User> users;
    private readonly IUserDao userDao;
    private IUserService userService = new UserHttpClient(new HttpClient());

    public AuthService(IUserLogic userLogic, IUserDao userDao)
    {
        this.userLogic = userLogic;
        users = new List<User>();
    }

    private async void LoadUsersIntoListAsync()
    {
        SearchUserParametersDto dto = new SearchUserParametersDto(null,null);
        IEnumerable<User> tempUsers = await userLogic.GetAsync(dto);
        users = tempUsers.ToList();
    }

    public Task<User> ValidateUserAsync(string username, string password)
    {
        SearchUserParametersDto dto = new SearchUserParametersDto(username);

        if (string.IsNullOrEmpty(username))
        {
            throw new Exception("Username cannot be null");
        }

        IEnumerable<User> tempUsers = userLogic.GetAsync(dto).Result;

        List<User?> users = new List<User?>();

        if (!tempUsers.Any())
        {
            throw new Exception("User with username: " + dto.username + " is not existing");
        }

        users = tempUsers.ToList();
        User? existingUser = users[0];

        if (existingUser == null)
        {
            throw new Exception("User not found");
        }

        if (!existingUser.Password.Equals(password))
        {
            throw new Exception("Password mismatch");
        }
        return Task.FromResult(existingUser);
    }

    public async Task<User> RegisterUserAsync(UserCreationDto dto)
    {
        users = await userLogic.GetAsync(new SearchUserParametersDto());

        if (string.IsNullOrEmpty(dto.username))
        {
            throw new ValidationException("Username cannot be null");
        }

        if (string.IsNullOrEmpty(dto.password))
        {
            throw new ValidationException("Password cannot be null");
        }

        User? existingUser = users.FirstOrDefault(u =>
            u.UserName.Equals(dto.username));


        if (existingUser != null)
        {
            throw new Exception("This username is taken");
        }

        existingUser = users.FirstOrDefault(u => u.Email.Equals(dto.email));

        if (existingUser != null)
        {
	        throw new Exception("Account with this email is already created!");
        }

        return await userService.Create(dto);
    }
}
