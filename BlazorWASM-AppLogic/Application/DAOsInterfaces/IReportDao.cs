using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface IReportDao
{
	Task<long> ReportPostAsync(ReportPostDto reportDto);
	Task<Report> GetByIdAsync(long id);

	Task<IEnumerable<Report>> GetAsync();
}
