using Application.DAOsInterfaces;
using Domain.DTOs;
using Grpc.Net.Client;
using GrpcClient;

using User = Domain.Models.User;


namespace Application.GrpcClients;

public class UserGrpcClient : IUserDao

{
    public async Task<IEnumerable<User>> GetAsync(SearchUserParametersDto searchParameters)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new UserService.UserServiceClient(channel);
        List<User> usersList = new List<User>();
        var reply = await client.GetUsersAsync(
            new RequestGetUsers
            {
                Username = searchParameters.username ?? "",
                Userid = searchParameters.userId ?? 0

            });

        for (int i = 0; i < reply.UserData.Count; i++)
        {
            UserData userData = reply.UserData[i];
            User? user = ConstructUser(userData);
            usersList.Add(user);
        }
        return await Task.FromResult(usersList.AsEnumerable());
    }

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

        return await Task.FromResult(ConstructUser(reply));
    }

    public async Task<IEnumerable<User>> GetLikes(int postId)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");

        var client = new UserService.UserServiceClient(channel);
        List<User> usersList = new List<User>();

        var reply = await client.GetUsersWhoLikedAsync(
            new RequestGetLikes
            {
                PostId = postId
            });

        for (int i = 0; i < reply.User.Count; i++)
        {
            UserData userData = reply.User[i];
            User? user = ConstructUser(userData);
            usersList.Add(user);
        }
        return await Task.FromResult(usersList.AsEnumerable());

    }

    private User ConstructUser(UserData userData)
    {
        return new User(userData.Id, userData.Username, userData.FirstName + " " + userData.LastName, userData.Password,
            userData.Email, userData.PhoneNumber, userData.LocationId);
    }

}
