using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class UserLogic : IUserLogic
{
    private readonly IUserDao userDao;
    
    public UserLogic(IUserDao userDao)
    {
        this.userDao = userDao;
    }
    public Task<IEnumerable<User>> GetAsync(SearchUserParametersDto searchParameters)
    {
        return userDao.GetAsync(searchParameters);
    }
}