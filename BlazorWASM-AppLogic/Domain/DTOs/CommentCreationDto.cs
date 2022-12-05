namespace Domain.DTOs;

public class CommentCreationDto
{
    public CommentCreationDto(long ownerId, long postId, string body)
    {
        OwnerId = ownerId;
        PostId = postId;
        Body = body;
    }

    public long OwnerId { get; }
    public long PostId { get; }
    public string Body { get; }
}