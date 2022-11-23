using Domain.Models;

namespace Domain.DTOs;

public class PostCreationDto
{
    public string title { get; }
    public string description { get; }
    public IList<string> tags { get; }

    public PostCreationDto(string title, string description, IList<string> tags)
    {
        this.title = title;
        this.description = description;
        this.tags = tags;
    }
}
