namespace Domain.DTOs;

public class SearchPostParameters
{
	public int? Id { get; }
	public int? UserId { get;}
	public string? TitleContains { get;}

	public SearchPostParameters(int? id, int? userId, string? titleContains)
	{
		Id = id;
		UserId = userId;
		TitleContains = titleContains;
	}



}
