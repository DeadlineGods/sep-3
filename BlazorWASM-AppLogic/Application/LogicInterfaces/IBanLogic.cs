using Domain.DTOs;

namespace Application.LogicInterfaces;

public interface IBanLogic
{
    Task<long> CreateAsync(BanCreationDto dto);
    Task<long> GetAsync(long postId);
}
