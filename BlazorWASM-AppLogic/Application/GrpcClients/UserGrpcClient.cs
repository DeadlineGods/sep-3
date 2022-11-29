using System.Collections;
using System.Security.AccessControl;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Application.DAOsInterfaces;
using Domain.DTOs;
using Domain.Models;
using Grpc.Net.Client;
using GrpcClient;

using User = Domain.Models.User;
using Post = Domain.Models.Post;


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

    public async Task<Like> LikePost(LikePostDto likeDto)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");

        var client = new UserService.UserServiceClient(channel);

        var reply = await client.LikePostAsync(
            new RequestLikePost
            {
                PostId = likeDto.postId,
                UserId = likeDto.userId
            });
        ResponseLikePost responseLikePost;
        return await Task.FromResult(ConstructLike(reply));
    }

    private User ConstructUser(UserData userData)
    {
        return new User(userData.Id, userData.Username, userData.FirstName + " " + userData.LastName, userData.Password,
            userData.Email, userData.PhoneNumber);
    }

    private Like ConstructLike(ResponseLikePost response)
    {
        return new Like(response.PostId, response.UserId);
    }
}
