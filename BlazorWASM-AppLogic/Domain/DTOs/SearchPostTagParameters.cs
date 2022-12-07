namespace Domain.DTOs;

public class SearchPostTagParameters
{
    public string? tagContains { get;}
    public long? postId { get;}

    public SearchPostTagParameters(string? tagContains = null, long? postId = null)
    {
        this.tagContains = tagContains;
        this.postId = postId;
    }
}