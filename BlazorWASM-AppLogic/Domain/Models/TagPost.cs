namespace Domain.Models;

public class TagPost : Tag
{
    public int? postId { get; set; }
    
    public TagPost(string tagName, int postId) : base(tagName)
    {
        this.postId = postId;
    }
}