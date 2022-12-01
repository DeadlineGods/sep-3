using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface ITagDao
{
    Task<IEnumerable<Tag>> GetAsync(SearchTagParameters searchParameters);
}