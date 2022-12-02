using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface ITagDao
{
    Task<IEnumerable<Tag>> GetPostTagAsync(SearchPostTagParameters searchParameters);
    //Task<IEnumerable<Tag>> GetTagListAsync(SearchTagListParameters searchParameters);
}