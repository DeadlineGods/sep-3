namespace Domain.DTOs;

public class AssignCommentToDto
{
    public long commentId { get; set; }
    public long parentId { get; set; }

    public AssignCommentToDto(long commentId, long parentId)
    {
        this.commentId = commentId;
        this.parentId = parentId;
    }
}