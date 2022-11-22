namespace Domain.DTOs;

public class SearchUserParametersDto
{
    public string? username { get; }
    public SearchUserParametersDto(string? username)
    {
        this.username = username;
    }
}