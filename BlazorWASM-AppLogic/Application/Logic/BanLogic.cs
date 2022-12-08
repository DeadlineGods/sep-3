using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;

namespace Application.Logic;

public class BanLogic : IBanLogic
{
    private readonly IBanDao BanDao;

    public BanLogic(IBanDao banDao)
    {
        BanDao = banDao;
    }

    public async Task<long> CreateAsync(BanCreationDto dto)
    {
	    return await BanDao.CreateAsync(dto);
    }
}
