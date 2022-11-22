using System.ComponentModel.DataAnnotations;
using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebAPI.Services;


public class AuthService : IAuthService
{
    private readonly IUserLogic userLogic;
    private IList<User> users;
    private readonly IUserDao userDao;

    public AuthService(IUserLogic userLogic, IUserDao userDao)
    {
        this.userLogic = userLogic;
        users = new List<User>();
    }

    private async void LoadUsersIntoList()
    {
        Console.Write("xxxxxxxxxxxxxxxxxxxx");
        SearchUserParametersDto dto = new SearchUserParametersDto(null);
        IEnumerable<User> tempUsers = await userLogic.GetAsync(dto);
        users = tempUsers.ToList();
    }

    public  Task<User> ValidateUser(string username, string password)
    {
        Console.Write("siema");
        SearchUserParametersDto dto = new SearchUserParametersDto(username);
        IEnumerable<User> tempUsers = userLogic.GetAsync(dto).Result;
        List<User?> users = new List<User?>();
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
        Console.Error.Write("Tutaj");
        return Task.FromResult(existingUser);
    }
}