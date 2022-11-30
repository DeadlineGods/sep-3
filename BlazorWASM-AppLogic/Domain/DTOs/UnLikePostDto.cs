namespace Domain.DTOs;

public class UnLikePostDto
{
    public int postId { get; }
    public long userId { get; }

    public UnLikePostDto(int postId, long userId)
    {
        this.postId = postId;
        this.userId = userId;
    }
}