namespace Domain.DTOs;

public class SearchPostParametersDto
{
	public long? Id { get; }
	public long? UserId { get;}
	public string? TitleContains { get;}

	public SearchPostParametersDto(long? id = null, long? userId = null, string? titleContains = null)
	{
		Id = id;
		UserId = userId;
		TitleContains = titleContains;
	}



}
