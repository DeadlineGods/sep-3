using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class UserLogic : IUserLogic
{
	private readonly IUserDao UserDao;

	public UserLogic(IUserDao userDao, IPostDao postDao)
	{
		UserDao = userDao;
	}

	public async Task<User> CreateAsync(UserCreationDto dto)
	{
		Validate(dto);

		User created = await UserDao.CreateAsync(dto);

		return created;
	}
	
	public async Task<IEnumerable<User>> GetLikes(int postId)
	{
		IEnumerable<User> users = new List<User>();
		try
		{
			users = await UserDao.GetLikes(postId);
		}
		catch (Exception e)
		{
			Console.WriteLine("Not found");
			throw;
		}

		return users;
	}
	
	private static void Validate(UserCreationDto userToCreate)
	{
		string userName = userToCreate.username;

		// User? existing = await Dao.GetByUsernameAsync(userName);
		// if (existing != null)
		// 	throw new Exception("Username already taken!");

		if (userName.Length < 3)
			throw new Exception("Username must be at least 3 characters!");

		if (userName.Length > 15)
			throw new Exception("Username must be less than 16 characters!");
	}
	public async Task<IEnumerable<User>> GetAsync(SearchUserParametersDto searchParameters)
	{
		IEnumerable<User> userWithUsername = new List<User>();
		try
		{
			userWithUsername = await UserDao.GetAsync(searchParameters);
		}
		catch (Exception e)
		{
			Console.WriteLine("not found ");
			throw;
		}

		return userWithUsername;
	}
}
