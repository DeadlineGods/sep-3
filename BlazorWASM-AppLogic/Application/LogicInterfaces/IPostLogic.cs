using System.Collections.Generic;
using System.Threading.Tasks;
using System.Threading.Tasks;
using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface IPostLogic
{
    Task<int> CreateAsync(PostCreationDto postCreationDto);
    Task DeleteAsync(long post_id, int user_id);
    Task<int> UpdateAsync(UpdatePostDto dto, int user_id);

    Task<IEnumerable<Post>> GetAsync(SearchPostParametersDto parametersDto);
    Task<IEnumerable<Post>> GetInRadiusAsync(Coordinate center, int radius);

}
