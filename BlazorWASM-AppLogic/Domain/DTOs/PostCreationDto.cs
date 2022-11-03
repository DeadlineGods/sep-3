using Domain.Models;

namespace Domain.DTOs;

public class PostCreationDto
{
    public int Id { get; set; }

    public int likes { get; }
    public string title { get; }

    public string description { get; }

    public PostCreationDto(string title, string description)
    {
        this.likes = likes;
        this.title = title;
        this.description = description;
    }
}