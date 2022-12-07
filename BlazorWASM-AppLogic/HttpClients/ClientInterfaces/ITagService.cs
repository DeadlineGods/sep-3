using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ITagService
{
    Task<ICollection<TagPost>> GetPostTagAsync(long? postId = null, string? tagContains = null);
    Task<ICollection<Tag>> GetTagListAsync(string? tagContains = null);
    Task<string[]> CreateAsync(PostTagCreationDto postTagCreation);
    Task DeleteAsync(long postId);


}