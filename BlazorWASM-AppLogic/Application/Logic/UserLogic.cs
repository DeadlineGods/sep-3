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

	public async Task<Like> LikePost(LikePostDto dto)
	{
		if (dto.postId == 0 && dto.userId == 0)
			throw new Exception("Post or user doesn't exist.");
		long l1 = dto.userId;
		if ( string.IsNullOrEmpty(dto.postId.ToString()) || string.IsNullOrEmpty(dto.userId.ToString()))
			throw new Exception("Ids cant be null");
		Like likePost = await Dao.LikePost(dto);
		
		Console.WriteLine("problem here");
		return likePost;
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
			userWithUsername = await Dao.GetAsync(searchParameters);
		}
		catch (Exception e)
		{
			Console.WriteLine("not found ");
			throw;
		}

		return userWithUsername;
	}
}
