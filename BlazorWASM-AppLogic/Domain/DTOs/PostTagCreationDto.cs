namespace Domain.DTOs;

public class PostTagCreationDto
{
    public long postId { get; }
    public string[] Tags { get; }

    public PostTagCreationDto(long postId, string[] tags)
    {
        this.postId = postId;
        Tags = tags;
    }
}