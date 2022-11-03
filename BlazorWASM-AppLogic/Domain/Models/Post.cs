namespace Domain.Models;

public class Post
{
    public int Id{ get; set; }
    public int likes { get; set; }
    public string title { get; set;}

    public string description { get; set;}
    public DateTime postedOn { get; set;}
    public Location location { get; set; }
    public Tag tag { get; set; }

    public Post(int likes, string title, string description, DateTime postedOn,Location location, Tag tag, int Id)
    {
        this.likes = likes;
        this.title = title;
        this.description = description;
        this.postedOn = postedOn;
        this.location = location;
        this.tag = tag;
        this.Id = Id;
    }
    
    public Post(int likes, string title, string description)
    {
        this.likes = likes;
        this.title = title;
        this.description = description;
    }

    
}