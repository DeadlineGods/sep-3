using System.Collections;
using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Grpc.Net.Client;
using GrpcClient;

namespace Application.GrpcClients;

public class CommentGrpcClient : ICommentDao
{
    private readonly IUserDao UserDao;
    private readonly IPostDao PostDao;

    public CommentGrpcClient(IUserDao userDao, IPostDao postDao)
    {
        UserDao = userDao;
        PostDao = postDao;
    }
    
    public async Task<long> CreateAsync(Comment comment)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new CommentService.CommentServiceClient(channel);

        var reply = await client.CreateCommentAsync(new RequestCreateComment()
        {
            Body = comment.Body,
            OwnerId = comment.OwnerId,
            PostId = comment.PostId
        });

        long createdCommentId = await Task.FromResult(reply.Id);
        
        return createdCommentId;
    }

    public async Task AssignCommentToParentAsync(AssignCommentToDto assignCommentToDto)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new CommentService.CommentServiceClient(channel);

        var reply = await client.AssignCommentToParentAsync(new RequestAssignCommentToParent()
        {
            Id = assignCommentToDto.commentId,
            ParentId = assignCommentToDto.parentId
        });
    }

    public async Task<Comment> GetByIdAsync(long id)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new CommentService.CommentServiceClient(channel);

        var reply = await client.GetByIdCommentAsync(new RequestGetGetByIdComment()
        {
            Id = id
        });

        return await ConstructAsync(reply);
    }

    public async Task<IEnumerable<Comment>> GetByPostAsync(long postId)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new CommentService.CommentServiceClient(channel);
        
        var reply = await client.GetByPostCommentsAsync(new RequestGetByPostComments()
        {
            PostId = postId 
        });

        return await ConstructListAsync(reply);
    }

    public async Task<IEnumerable<Comment>> GetSubCommentsAsync(long id)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new CommentService.CommentServiceClient(channel);

        var reply = await client.GetSubCommentsAsync(new RequestGetSubComments()
        {
            Id = id
        });

        return await ConstructListAsync(reply);
    }

    private async Task<Comment> ConstructAsync(CommentData commentData)
    {
        SearchPostParametersDto searchPostParametersDto = new(commentData.PostId, null, null);
        IEnumerable<Post> posts =  await PostDao.GetAsync(searchPostParametersDto);
       

        SearchUserParametersDto searchUserParametersDto = new(null, commentData.OwnerId);
        IEnumerable<User> users =  await UserDao.GetAsync(searchUserParametersDto);

        TimeSpan time = TimeSpan.FromMilliseconds(commentData.CreatedOnMilliseconds);
        DateTime createdAt = new DateTime(1970, 1, 1) + time;
        
        return new Comment()
        {
            Id = commentData.Id,
            Body = commentData.Body,
            OwnerId = users.FirstOrDefault().Id,
            OwnerUsername = users.FirstOrDefault().UserName,
            PostId = posts.FirstOrDefault().Id,
            CreatedAt = createdAt
        };
    }
    
    private async Task<IEnumerable<Comment>> ConstructListAsync(CommentsList reply)
    {
        ICollection<Comment> comments = new List<Comment>();

        foreach (var commentData in reply.Comments)
        {
            comments.Add(await ConstructAsync(commentData));
        }

        return comments.AsEnumerable();
    }

    public async Task DeleteAsync(long postId)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new CommentService.CommentServiceClient(channel);
        try
        {
            await client.DeleteCommentAsync(
                new RequestDeleteComment
                {
                    PostId = postId
                });
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }

        await Task.CompletedTask;
    }
}