using System.ComponentModel.DataAnnotations;
using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain;
using Domain.Models;
using HttpClients.ClientInterfaces;
using HttpClients.Implementations;
using Microsoft.AspNetCore.Mvc;
using Exception = System.Exception;

namespace WebAPI.Services;

public class AuthService : IAuthService
{
    private readonly IUserLogic userLogic;
    private readonly IAdminLogic adminLogic;
    private IEnumerable<User> users;
    private IUserService userService = new UserHttpClient(new HttpClient());

    public AuthService(IUserLogic userLogic, IAdminLogic adminLogic)
    {
        this.userLogic = userLogic;
        this.adminLogic = adminLogic;
        users = new List<User>();
    }

    private async void LoadUsersIntoListAsync()
    {
        SearchUserParametersDto dto = new SearchUserParametersDto(null,null);
        IEnumerable<User> tempUsers = await userLogic.GetAsync(dto);
        users = tempUsers.ToList();
    }

    public Task<LoginDto> ValidateUserAsync(string username, string password)
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

        LoginDto loginDto = new LoginDto()
        {
	        username = username,
	        password = password
        };

        return Task.FromResult(loginDto);
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

    public async Task<LoginDto> ValidateAdminAsync(string username, string password)
    {
	    if (string.IsNullOrEmpty(username))
	    {
		    throw new Exception("Username cannot be null");
	    }

	    IEnumerable<Admin> adminList = await adminLogic.GetAsync(username);

	    Admin? existing = adminList.FirstOrDefault();

	    if (existing == null)
	    {
		    throw new Exception("Admin not found");
	    }

	    if (!existing.password.Equals(password))
	    {
		    throw new Exception("Password is wrong!");
	    }

	    return new LoginDto
	    {
		    username = username,
		    password = password
	    };

    }
}
