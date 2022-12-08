namespace Domain.DTOs;

public class BanCreationDto
{
    public string Reason { get; set; }
    public string Admin { get; set; }
    public long? PostId { get; set; }
    public long? UserId { get; set; }
}