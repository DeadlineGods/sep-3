namespace Domain.DTOs;

public class IsPostLikedDto
{
    public long postId { get; }
    public long userId { get; }

    public IsPostLikedDto(long postId, long userId)
    {
        this.postId = postId;
        this.userId = userId;
    }
}