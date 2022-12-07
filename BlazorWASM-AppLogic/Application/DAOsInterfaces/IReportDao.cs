using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface IReportDao
{
	Task<int> ReportPostAsync(ReportPostDto reportDto);
	Task<Report> GetByIdAsync(int id);

}
