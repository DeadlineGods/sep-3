using System.Xml.Linq;
using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Geocoding;

namespace Application.Logic;

public class ReportLogic : IReportLogic
{
	private readonly IUserDao userDao;
	private readonly IPostDao postDao;
	private readonly IReportDao reportDao;
	private readonly IBanLogic banLogic;

	public ReportLogic(IUserDao userDao, IPostDao postDao, IReportDao reportDao, IBanLogic banLogic)
	{
		this.userDao = userDao;
		this.postDao = postDao;
		this.reportDao = reportDao;
		this.banLogic = banLogic;
	}

	public async Task<long> ReportPostAsync(ReportPostDto dto)
	{
		if (!await CheckIfPostExistsAsync(dto.postId))
		{
			throw new Exception($"Post with id={dto.postId} does not exist");
		}

		if (!await CheckIfUserExistsAsync(dto.userId))
		{
			throw new Exception($"User with id={dto.userId} does not exist");
		}

		if (dto.violationDesc.Equals(""))
		{
			throw new Exception("Report message cannot be empty!");
		}

		// TODO add more validation later, for example check if user already reported the post

		return await reportDao.ReportPostAsync(dto);
	}

	public async Task<Report> GetByIdAsync(long id)
	{
		Report report = await reportDao.GetByIdAsync(id);
		if (report == null)
			throw new Exception($"Report with id {id} does not exist");

		return report;
	}

	public async Task<IEnumerable<Report>> GetAsync()
	{
		IEnumerable<Report> reports = await reportDao.GetAsync();

		foreach (var report in reports)
		{
			if (await IsPostBanned(report.reportedPost.Id))
			{
				reports = reports.Where(r => !r.reportedPost.Equals(report.reportedPost));
			}

		}

		return reports;
	}

	private async Task<bool> CheckIfPostExistsAsync(long id)
	{
		SearchPostParametersDto searchPostParametersDto = new(id, null, null);
		IEnumerable<Post> existingPosts = await postDao.GetAsync(searchPostParametersDto);
		Post? existingPost = existingPosts.FirstOrDefault();

		return existingPost != null;
	}

	private async Task<bool> CheckIfUserExistsAsync(long id)
	{
		SearchUserParametersDto searchUserParametersDto = new(null, id);
		IEnumerable<User> existingUsers = await userDao.GetAsync(searchUserParametersDto);
		User? existingUser = existingUsers.FirstOrDefault();

		return existingUser != null;
	}

	private async Task<bool> IsPostBanned(long postId)
	{
		long exists = await banLogic.GetAsync(postId);

		return exists != 0;
	}
}
