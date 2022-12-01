using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ITagService
{
    Task<ICollection<Tag>> GetAsync(int? postId = null, string? tagContains = null);
}