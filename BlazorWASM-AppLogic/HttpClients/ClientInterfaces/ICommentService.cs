using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ICommentService
{
    Task<ICollection<Comment>> GetCommentsByPostAsync(long id);
    Task<ICollection<Comment>> GetAllSubCommentsAsync(long commentId);
    Task<long> CreateAsync(string body, long ownerId, long commentPostId);
    Task AssignCommentToParentAsync(long commentId, long parentCommentId);
}