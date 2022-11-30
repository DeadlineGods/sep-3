namespace Domain.DTOs;

public class IsPostLikedDto
{
    public int postId { get; }
    public long userId { get; }

    public IsPostLikedDto(int postId, long userId)
    {
        this.postId = postId;
        this.userId = userId;
    }
}