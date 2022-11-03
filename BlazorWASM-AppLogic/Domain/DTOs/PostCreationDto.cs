namespace Domain.DTOs;

public class PostCreationDto
{
    public int likes { get; }
    public string title { get; }

    public string description { get; }

    public PostCreationDto(int likes, string title, string description)
    {
        this.likes = likes;
        this.title = title;
        this.description = description;
    }
}