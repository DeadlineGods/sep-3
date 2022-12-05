namespace Domain.Models;

public class Like
{
    public long likedBy { get; set; }
    public long likedPost { get; set; }

    public Like(long likedBy, long likedPost)
    {
        this.likedBy = likedBy;
        this.likedPost = likedPost;
    }
}