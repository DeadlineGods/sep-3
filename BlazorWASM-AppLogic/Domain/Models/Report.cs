namespace Domain.Models;

public class Report
{
	public long reportId { get; set; }
	public string violation { get; set; }
	public User reportedBy { get; set; }
	public Post reportedPost { get; set; }

	public Report(long reportId, string violation, Post reportedPost, User reportedBy)
	{
		this.reportId = reportId;
		this.violation = violation;
		this.reportedBy = reportedBy;
		this.reportedPost = reportedPost;
	}
}
