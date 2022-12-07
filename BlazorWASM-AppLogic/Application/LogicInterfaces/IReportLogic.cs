using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface IReportLogic
{
	Task<int> ReportPostAsync(ReportPostDto dto);
	Task<Report> GetByIdAsync(int id);
}
