namespace Domain.Models;

public class TagPost : Tag
{
    public long postId { get; set; }
    
    public TagPost(string tagName, long postId) : base(tagName)
    {
        this.postId = postId;
    }
}