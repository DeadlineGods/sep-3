namespace Domain.Models;

public abstract class Comment
{
    public String body { get; set; }

    protected Comment(string body)
    {
        this.body = body;
    }
}