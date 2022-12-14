using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Geocoding;
using Grpc.Net.Client;
using GrpcClient;



namespace Application.GrpcClients;

public class ReportGrpcClient : IReportDao
{
	private readonly IUserDao UserDao;
	private readonly IPostDao PostDao;

	public ReportGrpcClient(IUserDao userDao, IPostDao postDao)
	{
		UserDao = userDao;
		PostDao = postDao;
	}

	public async Task<long> ReportPostAsync(ReportPostDto reportDto)
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

	public async Task<Report> GetByIdAsync(long id)
	{
		using var channel = GrpcChannel.ForAddress("http://localhost:6565");
		var client = new ReportService.ReportServiceClient(channel);

		var reply = await client.GetByIdReportAsync(new RequestGetByIdReport()
		{
			ReportId = id
		});

		return await ConstructAsync(reply);
	}

	public async Task<IEnumerable<Report>> GetAsync()
	{
		using var channel = GrpcChannel.ForAddress("http://localhost:6565");
		var client = new ReportService.ReportServiceClient(channel);

		var reply = await client.GetReportsAsync(new ReportEmpty());

		return await ConstructListAsync(reply);
	}

	private async Task<IEnumerable<Report>> ConstructListAsync(ResponseGetReports responseGetReports)
	{
		List<Report> reports = new List<Report>();

		foreach (var report in responseGetReports.Reports)
		{
			reports.Add(await ConstructAsync(report));
		}

		return reports;
	}

	private async Task<Report> ConstructAsync(ReportData reportData)
	{
		SearchUserParametersDto searchUserParametersDto = new SearchUserParametersDto(null, reportData.UserId);
		IEnumerable<User> users = await UserDao.GetAsync(searchUserParametersDto);

		SearchPostParametersDto searchPostParametersDto = new SearchPostParametersDto(reportData.PostId, null, null);
		IEnumerable<Post> posts = await PostDao.GetAsync(searchPostParametersDto);
		return new Report(reportData.ReportId, reportData.ViolationDesc, posts.FirstOrDefault(),
			users.FirstOrDefault());

	}

}
