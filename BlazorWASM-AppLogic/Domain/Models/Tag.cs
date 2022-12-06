using System;

namespace Domain.Models;

public class Tag
{
    public string tagName{ get; set; }

    public Tag(string tagName)
    {
        this.tagName = tagName;
    }
}
