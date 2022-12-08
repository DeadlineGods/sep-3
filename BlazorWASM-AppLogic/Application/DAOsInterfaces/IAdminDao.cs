using Domain.Models;

namespace Application.DAOsInterfaces;

public interface IAdminDao
{
	Task<IEnumerable<Admin>> GetAsync(string? username);

}
