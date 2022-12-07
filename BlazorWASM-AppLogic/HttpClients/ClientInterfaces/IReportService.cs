using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IReportService
{
	Task<int> ReportPostAsync(ReportPostDto dto);
	Task<ICollection<Report>> GetReportById(long reportId);

}
