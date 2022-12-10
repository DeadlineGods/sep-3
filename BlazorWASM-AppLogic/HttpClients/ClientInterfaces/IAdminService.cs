using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IAdminService
{
    Task<IEnumerable<Admin>> GetAsync(string identityName);
}
