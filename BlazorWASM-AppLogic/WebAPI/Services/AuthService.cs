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

    private async void LoadUsersIntoList()
    {
        SearchUserParametersDto dto = new SearchUserParametersDto(null,null);
        IEnumerable<User> tempUsers = await userLogic.GetAsync(dto);
        users = tempUsers.ToList();
    }

    public  Task<User> ValidateUser(string username, string password)
    {
        Console.Write("siema");
        SearchUserParametersDto dto = new SearchUserParametersDto(username, null);
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
        
        if (!existingUser.password.Equals(password))
        {
            throw new Exception("Password mismatch");
        }
        return Task.FromResult(existingUser);
    }

    public async Task<User> RegisterUser(UserCreationDto dto)
    {
        users = await userService.GetUsers();

        if (string.IsNullOrEmpty(dto.username))
        {
            throw new ValidationException("Username cannot be null");
        }

        if (string.IsNullOrEmpty(dto.password))
        {
            throw new ValidationException("Password cannot be null");
        }

        User? existingUser = users.FirstOrDefault(u =>
            u.userName.Equals(dto.username, StringComparison.OrdinalIgnoreCase));

        if (existingUser != null)
        {
            throw new Exception("This username is taken");
        }

     
        return await userService.Create(new UserAuthDto(dto.username,dto.firstName,dto.lastName,dto.password,dto.email,dto.phoneNumber));
    }
}