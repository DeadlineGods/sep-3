namespace Domain.DTOs;

public class SearchTagListParameters
{
    public string? TagContains { get;}

    public SearchTagListParameters(string? tagContains = null)
    {
        TagContains = tagContains;
    }
}