using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IAdminService
{
    Task<Admin> GetAsync(string identityName);
}
