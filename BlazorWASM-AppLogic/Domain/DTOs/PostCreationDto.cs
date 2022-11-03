namespace Domain.DTOs;

public class PostCreationDto
{
    public string title { get; }

    public string description { get; }

    public PostCreationDto(string title, string description)
    {
        this.title = title;
        this.description = description;
    }
}