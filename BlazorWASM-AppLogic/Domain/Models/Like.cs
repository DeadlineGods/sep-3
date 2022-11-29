namespace Domain.Models;

public class Like
{
    public int likedBy { get; set; }
    public long likedPost { get; set; }

    public Like(int likedBy, long likedPost)
    {
        this.likedBy = likedBy;
        this.likedPost = likedPost;
    }
}