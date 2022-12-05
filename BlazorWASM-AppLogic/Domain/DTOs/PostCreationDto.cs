using Domain.Models;

namespace Domain.DTOs;

public class PostCreationDto
{
    public string Title { get; }
    public string Description { get; }
    public long UserId { get; }
    public string ImgUrl { get; }
    public int LocationId { get; set; }

    public PostCreationDto(string title, long userId, string description, string imgUrl, int locationId)
    {
        Title = title;
        Description = description;
        UserId = userId;
        ImgUrl = imgUrl;
        LocationId = locationId;
    }
}
