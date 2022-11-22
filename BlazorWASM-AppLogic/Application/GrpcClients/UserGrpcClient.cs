using System.Collections;
using Application.DAOsInterfaces;
using Domain.DTOs;
using Domain.Models;
using Grpc.Net.Client;
using GrpcClient;
using User = Domain.Models.User;


namespace Application.GrpcClients;

public class UserGrpcClient : IUserDao
{
    public async Task<IEnumerable<User>> GetAsync(SearchUserParametersDto searchParameters)
    {
        
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new GrpcClient.User.UserClient(channel);
        List<User> usersList = new List<User>();
        var reply = await client.GetUsersAsync(
            new RequestGetUsers
            {
                Username = searchParameters.username
            });
        for (int i = 0; i < reply.CalculateSize(); i++)
        {
            UserData userData = reply.UserData[i];
            User? user = new User(userData.Username, userData.FirstName, userData.Password, userData.Email,
                userData.PhoneNumber);
            usersList.Add(user);
        }
        
        return await Task.FromResult(usersList.AsEnumerable());
    }
}