using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ILikeService
{
    Task<Like> LikePostAsync(LikePostDto dto);
    Task UnLikePostAsync(UnLikePostDto unLikePostDto);
    Task<bool> IsPostLikedAsync(IsPostLikedDto isPostLikedDto);
    Task<int> CountLikesAsync(int postId);
}