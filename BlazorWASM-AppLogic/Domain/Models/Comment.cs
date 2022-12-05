using System;

namespace Domain.Models;

public class Comment
{
    public long Id { get; set; }
    public string Body { get; set; }
    public long OwnerId { get; set; }
    public string OwnerUsername { get; set; }
    public long PostId { get; set; }
    public DateTime CreatedAt { get; set; }
}