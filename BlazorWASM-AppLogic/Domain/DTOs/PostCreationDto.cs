using Domain.Models;

namespace Domain.DTOs;

public class PostCreationDto
{
    public string Title { get; }
    public string Description { get; }
    public long UserId { get; }
    public string ImgUrl { get; }
    public IList<string> Tags { get; }

    public PostCreationDto(string title, long userId, string description, string imgUrl, IList<string> tags)
    {
        Title = title;
        Description = description;
        Tags = tags;
        UserId = userId;
        ImgUrl = imgUrl;
    }
}
