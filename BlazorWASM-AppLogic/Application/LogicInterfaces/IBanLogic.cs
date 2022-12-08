using Domain.DTOs;

namespace Application.LogicInterfaces;

public interface IBanLogic
{
    Task CreateAsync(BanCreationDto dto);
}