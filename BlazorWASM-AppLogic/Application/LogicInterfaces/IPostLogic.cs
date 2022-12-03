using System.Collections.Generic;
using System.Threading.Tasks;
using System.Threading.Tasks;
using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface IPostLogic
{
    Task<int> CreateAsync(PostCreationDto postCreationDto);
    Task<IEnumerable<Post>> GetAsync(SearchPostParameters parameters);
    Task<IEnumerable<Post>> GetInRadiusAsync(Coordinate center);
    Task DeleteAsync(int id);
}
