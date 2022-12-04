using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface ICommentLogic
{
    Task<long> CreateAsync(CommentCreationDto creationDto);
    Task AssignCommentToParentAsync(AssignCommentToDto assignCommentToDto);
    Task<IEnumerable<Comment>> GetAsync(long postId);
    Task<IEnumerable<Comment>> GetSubCommentsAsync(long id);
    Task<Comment> GetByIdAsync(long id);
}