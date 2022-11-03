namespace Domain.Models;

public class Tag
{
    public String tagName{ get; set; }

    public Tag(String tagName)
    {
        this.tagName = tagName;
    }
}