namespace Domain.DTOs;

public class ReportPostDto
{

	public String violationDesc { get; }

	public int postId { get; }
	public int userId { get; }

	public ReportPostDto(String violationDesc, int postId, int userId)
	{

		this.violationDesc = violationDesc;
		this.postId = postId;
		this.userId = userId;
	}
}
