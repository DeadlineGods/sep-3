using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface IUserLogic
{
    
    Task<IEnumerable<User>> GetAsync(SearchUserParametersDto searchParameters);
    Task<User> CreateAsync(UserCreationDto dto);
    Task<IEnumerable<User>> GetLikes(int postId);
}
