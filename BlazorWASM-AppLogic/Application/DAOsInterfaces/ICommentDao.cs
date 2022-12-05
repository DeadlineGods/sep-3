using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface ICommentDao
{
    Task<long> CreateAsync(Comment comment);
    Task AssignCommentToParentAsync(AssignCommentToDto assignCommentToDto);
    Task<Comment> GetByIdAsync(long id);
    Task<IEnumerable<Comment>> GetByPostAsync(long postId);
    Task<IEnumerable<Comment>> GetSubCommentsAsync(long id);
}