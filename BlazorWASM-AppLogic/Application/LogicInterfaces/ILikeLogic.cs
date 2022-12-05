using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterfaces;

public interface ILikeLogic
{
    Task<Like> LikePostAsync(LikePostDto dto);
    Task UnLikePostAsync(UnLikePostDto unLikePostDto);
    Task<bool> IsPostLikedAsync(IsPostLikedDto isPostLikedDto);
    Task<int> CountLikesAsync(int postId);
}