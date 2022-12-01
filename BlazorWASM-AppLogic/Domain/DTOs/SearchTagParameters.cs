namespace Domain.DTOs;

public class SearchTagParameters
{
    public string? TagContains { get;}
    public int? postId { get;}

    public SearchTagParameters(string? tagContains = null, int? postId = null)
    {
        TagContains = tagContains;
        this.postId = postId;
    }
}