namespace Domain.DTOs;

public class LikePostDto
{
    public int postId { get; }
    public long userId { get; }

    public LikePostDto(int postId, long userId)
    {
        this.postId = postId;
        this.userId = userId;
    }
}