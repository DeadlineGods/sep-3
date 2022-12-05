using System;
using System.Collections.Generic;

namespace Domain.Models;

public class Post
{
    public int Id{ get; set; }
    public User Owner { get; set; }
    public int Likes { get; set; } = 0;
    public string Title { get; set; }
    public string Description { get; set; }
    public string ImgUrl { get; set; }
    public DateTime PostedOn { get; set; }
    public Location Location { get; set; }
    public IList<string> Tags { get; set; }

    public Post() { }

    public Post(int id, User owner, int likes, string title, string description, string imgUrl, DateTime postedOn, IList<string> tags)
    {
	    Id = id;
	    Owner = owner;
	    Likes = likes;
	    Title = title;
	    ImgUrl = imgUrl;
	    Description = description;
	    PostedOn = postedOn;
	    Tags = tags;
    }

    public Post(int id, User owner, int likes, string title, string imgUrl ,string description, DateTime postedOn, Location location)
    {
	    Id = id;
	    Likes = likes;
	    Title = title;
	    Description = description;
	    PostedOn = postedOn;
	    Owner = owner;
	    ImgUrl = imgUrl;
	    Location = location;
    }


}
