using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.Models;

namespace Application.Logic;

public class AdminLogic : IAdminLogic
{
	private readonly IAdminDao adminDao;

	public AdminLogic(IAdminDao adminDao)
	{
		this.adminDao = adminDao;
	}

	public async Task<IEnumerable<Admin>> GetAsync(string? username)
	{
		IEnumerable<Admin> admins = new List<Admin>();
		try
		{
			admins = await adminDao.GetAsync(username);
		}
		catch (Exception e)
		{
			Console.WriteLine("Admin was not found!");
			throw;
		}

		return admins;
	}
}
