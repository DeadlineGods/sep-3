﻿using Application.DAOsInterfaces;
using Domain.DTOs;
using Domain.Models;
using Grpc.Net.Client;
using GrpcClient;

namespace Application.GrpcClients;

public class LikeGrpcClient : ILikeDao
{
    public async Task<int> CountLikesAsync(int postId)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new LikeService.LikeServiceClient(channel);
        
        var reply = client.CountLikes
        (new RequestCountLikes()
        {
            PostId = postId
        });
        return await Task.FromResult(reply.LikesNo);
    }

    public async Task<Like> LikePostAsync(LikePostDto likeDto)
    {   
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new LikeService.LikeServiceClient(channel);

        var reply = await client.LikePostAsync(
            new RequestLikePost
            {
                PostId = likeDto.postId,
                UserId = likeDto.userId
            });
        return await Task.FromResult(ConstructLike(reply));
    }

    public async Task UnLikePostAsync(UnLikePostDto unLikePostDto)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new LikeService.LikeServiceClient(channel);

        var reply = await client.UnLikePostAsync(
            new RequestUnLikePost
            {
                PostId = unLikePostDto.postId,
                UserId = unLikePostDto.userId
            }
        );
    }

    public async Task<bool> IsPostLikedAsync(IsPostLikedDto isPostLikedDto)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new LikeService.LikeServiceClient(channel);

        var reply = await client.IsPostLikedAsync(
            new RequestIsPostLiked()
            {
                PostId = isPostLikedDto.postId,
                UserId = isPostLikedDto.userId
            }
        );

        return await Task.FromResult(reply.IsLiked);
    }
    
    private Like ConstructLike(ResponseLikePost response)
    {
        return new Like(response.PostId, response.UserId);
    }
}