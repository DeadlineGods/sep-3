using Application.DAOsInterfaces;
using Domain.DTOs;
using Domain.Models;
using Grpc.Net.Client;

namespace Application.GrpcClients;

public class UserGrpcClient : IUserDao
{
    public async Task<IEnumerable<User>> GetAsync(SearchUserParametersDto searchParameters)
    {
        /*
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new GrpcClient.User.GetUsers(channel);
        var reply = await client.GetUsersAsync(
            new RequestGetUser
            {

            });*/
        IEnumerable<User> replyUsers = new List<User>();
        return await Task.FromResult(replyUsers);
    }
}