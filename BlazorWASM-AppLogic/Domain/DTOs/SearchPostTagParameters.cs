namespace Domain.DTOs;

public class SearchPostTagParameters
{
    public string? TagContains { get;}
    public int? postId { get;}

    public SearchPostTagParameters(string? tagContains = null, int? postId = null)
    {
        TagContains = tagContains;
        this.postId = postId;
    }
}