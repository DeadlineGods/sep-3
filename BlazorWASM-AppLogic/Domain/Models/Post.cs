using System;
using System.Collections.Generic;

namespace Domain.Models;

public class Post
{
    public long Id{ get; set; }
    public User Owner { get; set; }
    public int Likes { get; set; } = 0;
    public string Title { get; set; }
    public string Description { get; set; }
    public string ImgUrl { get; set; }
    public DateTime PostedOn { get; set; }
    public Coordinate Coordinate { get; set; }
    public IList<string> Tags { get; set; }

    public Post() { }

    public Post(long id, User owner, int likes, string title, string description, string imgUrl, DateTime postedOn, Coordinate? coordinate, IList<string> tags)
    {
	    Id = id;
	    Owner = owner;
	    Likes = likes;
	    Title = title;
	    ImgUrl = imgUrl;
	    Description = description;
	    PostedOn = postedOn;
	    Coordinate = coordinate;
	    Tags = tags;
    }

    public Post(long id, User owner, int likes, string title, string imgUrl ,string description, DateTime postedOn)
    {
	    Id = id;
	    Likes = likes;
	    Title = title;
	    Description = description;
	    PostedOn = postedOn;
	    Owner = owner;
	    ImgUrl = imgUrl;
    }


}
