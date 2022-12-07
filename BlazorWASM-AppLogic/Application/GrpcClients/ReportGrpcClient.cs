using Application.DAOsInterfaces;
using Domain.DTOs;
using Domain.Models;
using Grpc.Net.Client;
using GrpcClient;



namespace Application.GrpcClients;

public class ReportGrpcClient : IReportDao
{
	private readonly IUserDao UserDao;
	private readonly IPostDao PostDao;
	public async Task<int> ReportPostAsync(ReportPostDto reportDto)
	{
		using var channel = GrpcChannel.ForAddress("http://localhost:6565");
		var client = new ReportService.ReportServiceClient(channel);

		var reply = await client.ReportPostAsync(
			new RequestReportPost
			{
				ViolationDesc= reportDto.violationDesc,
				PostId = reportDto.postId,
				UserId = reportDto.userId
			});

		return await Task.FromResult(reply.ReportId);
	}

	public async Task<Report> GetByIdAsync(int id)
	{
		using var channel = GrpcChannel.ForAddress("http://localhost:6565");
		var client = new ReportService.ReportServiceClient(channel);

		var reply = await client.GetByIdReportAsync(new RequestGetByIdReport()
		{
			ReportId = id
		});

		return await ConstructAsync(reply);
	}

	private async Task<Report> ConstructAsync(ResponseGetReport responseGetReport)
	{
		return new Report(responseGetReport.ReportId, responseGetReport.ViolationDesc, responseGetReport.PostId,
			responseGetReport.UserId);

	}

}
