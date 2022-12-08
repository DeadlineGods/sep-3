using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface IReportLogic
{
	Task<long> ReportPostAsync(ReportPostDto dto);
	Task<Report> GetByIdAsync(long id);
	Task<IEnumerable<Report>> GetAsync();
}
