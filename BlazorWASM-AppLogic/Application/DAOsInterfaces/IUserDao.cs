using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface IUserDao
{
	Task<User> CreateAsync(UserCreationDto user);
}
