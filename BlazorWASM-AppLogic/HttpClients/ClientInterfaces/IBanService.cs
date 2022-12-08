using Domain.DTOs;

namespace HttpClients.ClientInterfaces;

public interface IBanService
{
    Task CrateAsync(BanCreationDto dto);
}