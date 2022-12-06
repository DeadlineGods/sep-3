using System.Collections.Generic;
using System.Threading.Tasks;
using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface IPostDao
{
	Task<long> CreateAsync(PostCreationDto postCreationDto);
	Task<IEnumerable<Post>> GetAsync(SearchPostParametersDto parametersDto);
    Task DeleteAsync(long id);
}
