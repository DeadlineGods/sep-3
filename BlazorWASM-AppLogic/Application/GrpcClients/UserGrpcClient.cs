using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Application.DAOsInterfaces;
using Domain.DTOs;
using Domain.Models;
using Grpc.Net.Client;
using GrpcClient;

namespace Application.GrpcClients;


public class UserGrpcClient : IUserDao
{
	public async Task<User> CreateAsync(UserCreationDto user)
	{
		using var channel = GrpcChannel.ForAddress("http://localhost:6565");

		var client = new UserService.UserServiceClient(channel);

		var reply = await client.CreateUserAsync(
			new RequestCreateUser
			{
				Username = user.username,
				FirstName = user.firstName,
				LastName = user.lastName,
				Email = user.email,
				Password = user.password,
				PhoneNumber = user.phoneNumber
			});

		return await Task.FromResult(CreateUser(reply));
	}


	private User CreateUser(UserData userData)
	{
		return new User(userData.Username, userData.FirstName + " " + userData.LastName, userData.Password,
			userData.Email, userData.PhoneNumber);
	}
}
