using System;

namespace Domain.DTOs;

public class PostDto
{
	public long id { get; }
	public string title { get; }
	public string description { get; }
	public DateTime date { get; }


	public PostDto(long id, string title, string description, DateTime date)
	{
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
	}
}
