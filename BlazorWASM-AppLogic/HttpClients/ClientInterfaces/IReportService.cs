using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IReportService
{
	Task<int> ReportPostAsync(ReportPostDto dto);
	Task<Report> GetReportById(long reportId);

	Task<IEnumerable<Report>> GetAsync();
}
