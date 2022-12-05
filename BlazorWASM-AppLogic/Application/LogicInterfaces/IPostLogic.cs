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
    Task DeleteAsync(int post_id, int user_id);
    Task<int> UpdateAsync(UpdatePostDto dto, int user_id);

}
