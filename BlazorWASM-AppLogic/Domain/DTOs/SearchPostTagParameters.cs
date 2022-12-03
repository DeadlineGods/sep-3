namespace Domain.DTOs;

public class SearchPostTagParameters
{
    public string? tagContains { get;}
    public int? postId { get;}

    public SearchPostTagParameters(string? tagContains = null, int? postId = null)
    {
        this.tagContains = tagContains;
        this.postId = postId;
    }
}