using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface ICommentDao
{
    Task<long> CreateAsync(Comment comment);
    Task AssignCommentToParentAsync(AssignCommentToDto assignCommentToDto);
    Task<Comment> GetAsync(long id);
}