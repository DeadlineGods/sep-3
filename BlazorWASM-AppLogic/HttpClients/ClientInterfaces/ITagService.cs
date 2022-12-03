using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ITagService
{
    Task<ICollection<TagPost>> GetAsync(int? postId = null, string? tagContains = null);
}