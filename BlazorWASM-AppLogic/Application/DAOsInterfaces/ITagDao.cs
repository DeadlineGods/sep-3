using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface ITagDao
{
    Task<IEnumerable<TagPost>> GetPostTagAsync(SearchPostTagParameters searchParameters);
    Task<IEnumerable<Tag>> GetTagListAsync(SearchTagListParameters searchParameters);
}