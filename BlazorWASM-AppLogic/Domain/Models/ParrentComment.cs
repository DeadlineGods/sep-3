namespace Domain.Models;

public class ParrentComment : Comment
{
    public Post post { get; set; }

    public ParrentComment(string body, Post post) : base(body)
    {
        this.post = post;
    }
}