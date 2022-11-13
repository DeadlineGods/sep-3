namespace Domain.Models;

public class Report
{
    public int violation { get; set; }
    public User reportedBy { get; set; }
    public Post reportedPost { get; set; }

    public Report(int violation, User reportedBy, Post reportedPost)
    {
        this.violation = violation;
        this.reportedBy = reportedBy;
        this.reportedPost = reportedPost;
    }
}