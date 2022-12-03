using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ITagService
{
    Task<ICollection<TagPost>> GetPostTagAsync(int? postId = null, string? tagContains = null);
    Task<ICollection<Tag>> GetTagListAsync(string? tagContains = null);
}