namespace Domain.DTOs;

public class SearchUserParametersDto
{
    public string? username { get; }
    public long? userId { get; }
    public SearchUserParametersDto(string? username=null, long? userId=null)
    {
        this.username = username;
        this.userId = userId;
    }
}