using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class CommentLogic : ICommentLogic
{
    private readonly ICommentDao commentDao;
    private readonly IUserDao userDao;
    private readonly IPostDao postDao;

    public CommentLogic(ICommentDao commentDao, IUserDao userDao, IPostDao postDao)
    {
        this.commentDao = commentDao;
        this.userDao = userDao;
        this.postDao = postDao;
    }
    public async Task<long> CreateAsync(CommentCreationDto creationDto)
    {
        
        SearchPostParametersDto searchPostParametersDto = new(creationDto.PostId, null, null);
        IEnumerable<Post> posts =  await postDao.GetAsync(searchPostParametersDto);
        Post? post= posts.FirstOrDefault();
        if (post == null)
            throw new Exception($"Post with id {creationDto.PostId} does not exist");

        SearchUserParametersDto searchUserParametersDto = new(null, creationDto.OwnerId);
        IEnumerable<User> users =  await userDao.GetAsync(searchUserParametersDto);
        User? user = users.FirstOrDefault();
        if (user == null)
            throw new Exception($"User with id {creationDto.OwnerId} does not exist");
        
        Comment comment = new Comment()
        {
            Owner = user,
            PostedOn = post,
            Body = creationDto.Body,
        };

        return await commentDao.CreateAsync(comment);
    }

    public async Task AssignCommentToParentAsync(AssignCommentToDto assignCommentToDto)
    {
       await AssignCommentToParentValidation(assignCommentToDto);

       await commentDao.AssignCommentToParentAsync(assignCommentToDto);
    }

    private async Task AssignCommentToParentValidation(AssignCommentToDto assignCommentToDto)
    {
        Comment? commentExisting = await commentDao.GetAsync(assignCommentToDto.commentId);
        if (commentExisting == null)
        {
            throw new Exception($"Comment with id {assignCommentToDto.commentId} does not exist");

        }
        
        Comment? parentCommentExisting = await commentDao.GetAsync(assignCommentToDto.parentId);
        if (parentCommentExisting == null)
        {
            throw new Exception($"Parent comment with id {assignCommentToDto.parentId} does not exist");

        }

        if (commentExisting.PostedOn.Id != parentCommentExisting.PostedOn.Id)
        {
            throw new Exception(
                $"Can not assign comment {assignCommentToDto.commentId} to parent comment {assignCommentToDto.parentId} because they do not share the same post");
        }

        if (commentExisting.Id == parentCommentExisting.Id)
        {
            throw new Exception($"Can not assign comment to be parent of it self");
        }
    }
}