using System.Collections.Generic;
using System.Threading.Tasks;
using System.Threading.Tasks;
using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface IPostLogic
{
    Task<Post> CreateAsync(PostCreationDto postCreationDto);
    Task<IEnumerable<Post>> GetAsync(SearchPostParameters parameters);
    Task DeleteAsync(int id);
}
