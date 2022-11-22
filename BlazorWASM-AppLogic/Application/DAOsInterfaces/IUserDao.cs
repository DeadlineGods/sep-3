using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface IUserDao
{
    public Task<IEnumerable<User>> GetAsync(SearchUserParametersDto searchParameters);
    Task<User> CreateAsync(UserCreationDto user);
}
