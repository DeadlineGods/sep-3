using System;

namespace Domain.Models;

public class Comment
{
    public long Id { get; set; }
    public string Body { get; set; }
    public User Owner { get; set; }
    public Post PostedOn { get; set; }
    public DateTime CreatedAt { get; set; }
}