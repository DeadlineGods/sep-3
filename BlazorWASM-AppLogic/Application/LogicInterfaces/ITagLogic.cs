using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface ITagLogic
{
    Task<IEnumerable<TagPost>> GetPostTagAsync(SearchPostTagParameters searchParameters);
    Task<IEnumerable<Tag>> GetTagListAsync(SearchTagListParameters searchParameters);
}