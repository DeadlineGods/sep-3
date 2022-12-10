using Domain.Models;

namespace Application.LogicInterfaces;

public interface IAdminLogic
{
	Task<IEnumerable<Admin>> GetAsync(string? username);
}
