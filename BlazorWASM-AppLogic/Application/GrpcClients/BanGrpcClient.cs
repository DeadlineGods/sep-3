using Application.DAOsInterfaces;
using Domain.DTOs;
using Grpc.Net.Client;
using GrpcClient;

namespace Application.GrpcClients;

public class BanGrpcClient : IBanDao
{
	public async Task<long> CreateAsync(BanCreationDto dto)
	{
		using var channel = GrpcChannel.ForAddress("http://localhost:6565");
		var client = new BanService.BanServiceClient(channel);

		var reply = await client.BanPostAsync(
			new BanData
			{
				Admin = dto.Admin,
				Reason = dto.Reason,
				PostId = dto.PostId
			});

		return await Task.FromResult(reply.Id);
	}
}
