using Application.DAOsInterfaces;
using Domain.Models;
using Grpc.Net.Client;
using GrpcClient;

namespace Application.GrpcClients;

public class AdminGrpcClient : IAdminDao
{
	public async Task<IEnumerable<Admin>> GetAsync(string? username)
	{
		using var channel = GrpcChannel.ForAddress("http://localhost:6565");
		var client = new AdminService.AdminServiceClient(channel);

		var reply = await client.GetAdminAsync(
			new AdminUsername
			{
				Username = username ?? ""
			});

		IList<Admin> admins = new List<Admin>();
		foreach (var admin in reply.Admins)
		{
			admins.Add(new Admin(admin.Username, admin.Password, admin.Email));
		}

		return await Task.FromResult(admins);
	}
}
