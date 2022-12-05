namespace Domain.DTOs;

public class UnLikePostDto
{
    public long postId { get; }
    public long userId { get; }

    public UnLikePostDto(long postId, long userId)
    {
        this.postId = postId;
        this.userId = userId;
    }
}