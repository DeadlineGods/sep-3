namespace Domain.DTOs;

public class LikePostDto
{
    public long postId { get; }
    public long userId { get; }

    public LikePostDto(long postId, long userId)
    {
        this.postId = postId;
        this.userId = userId;
    }
}