using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface ITagLogic
{
    Task<IEnumerable<Tag>> GetAsync(SearchTagParameters searchParameters);
}