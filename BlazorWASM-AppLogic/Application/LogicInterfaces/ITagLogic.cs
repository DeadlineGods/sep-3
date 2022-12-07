using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface ITagLogic
{
    Task<string[]> CreateAsync(PostTagCreationDto dto);
    Task<IEnumerable<TagPost>> GetPostTagAsync(SearchPostTagParameters searchParameters);
    Task<IEnumerable<Tag>> GetTagListAsync(SearchTagListParameters searchParameters);
    Task DeleteTask(long postId);
}