namespace Domain.DTOs;

public class PostTagCreationDto
{
    public int postId { get; }
    public string[] Tags { get; }

    public PostTagCreationDto(int postId, string[] tags)
    {
        this.postId = postId;
        Tags = tags;
    }
}