using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface ICommentLogic
{
    Task<long> CreateAsync(CommentCreationDto creationDto);
    Task AssignCommentToParentAsync(AssignCommentToDto assignCommentToDto);
}