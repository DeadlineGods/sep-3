namespace Domain.DTOs;

public class PostDto
{
	public int id { get; }
	public string title { get; }
	public string description { get; }
	public DateTime date { get; }


	public PostDto(int id, string title, string description, DateTime date)
	{
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
	}
}
