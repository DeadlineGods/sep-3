using System.Collections.Generic;
using System.Threading.Tasks;
using System.Threading.Tasks;
using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface IPostLogic
{
    Task<long> CreateAsync(PostCreationDto postCreationDto);
    Task<IEnumerable<Post>> GetAsync(SearchPostParametersDto parametersDto);
    Task<IEnumerable<Post>> GetInRadiusAsync(Coordinate center, int radius);
    Task DeleteAsync(long id);
}
