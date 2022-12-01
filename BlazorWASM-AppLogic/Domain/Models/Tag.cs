using System;

namespace Domain.Models;

public class Tag
{
    public String tagName{ get; set; }
    public int? postId { get; set; }

    public Tag(String tagName)
    {
        this.tagName = tagName;
    }

    public Tag(string tagName, int postId)
    {
        this.tagName = tagName;
        this.postId = postId;
    }
}
