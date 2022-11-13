namespace Domain.Models;

public class BanPost
{
    public String reason { get; set; }
    public Post post { get; set; }
    public Admin admin { get; set; }

    public BanPost(string reason, Post post, Admin admin)
    {
        this.reason = reason;
        this.post = post;
        this.admin = admin;
    }
}