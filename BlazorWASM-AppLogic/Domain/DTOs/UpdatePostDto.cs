namespace Domain.DTOs;

public class UpdatePostDto
{
    public int Id { get; }
        public string? Title { get; set; }
        public string? Description { get; set; }
        public IList<string> Tags { get; set; }

        public UpdatePostDto(int id)
        {
            Id = id;
        }
}