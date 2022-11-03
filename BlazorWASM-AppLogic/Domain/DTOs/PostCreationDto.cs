namespace DefaultNamespace;

public class PostCreationDto
{
    public int likes { get; }
    public string title { get; }

    public string description { get; }
    public Date postedOn { get; }

    public PostCreationDto(int likes, string title, string description, Date postedOn)
    {
        this.likes = likes;
        this.title = title;
        this.description = description;
        this.postedOn = postedOn;
    }
  
}