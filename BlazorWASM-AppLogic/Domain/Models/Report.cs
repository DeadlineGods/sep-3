namespace Domain.Models;

public class Report
{
	public int reportId { get; set; }
	public string violation { get; set; }
	public int reportedBy { get; set; }
	public int reportedPost { get; set; }

	public Report(int reportId, string violation, int reportedPost, int reportedBy)
	{
		this.reportId = reportId;
		this.violation = violation;
		this.reportedBy = reportedBy;
		this.reportedPost = reportedPost;
	}
}
