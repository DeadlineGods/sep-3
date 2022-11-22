using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class UserLogic : IUserLogic
{
	private readonly IUserDao Dao;

	public UserLogic(IUserDao dao)
	{
		this.Dao = dao;
	}

	public async Task<User> CreateAsync(UserCreationDto dto)
	{
		Validate(dto);

		User created = await Dao.CreateAsync(dto);

		return created;
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
	public Task<IEnumerable<User>> GetAsync(SearchUserParametersDto searchParameters)
	{
		return Dao.GetAsync(searchParameters);
	}
}
