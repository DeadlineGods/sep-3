using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface ILikeDao
{
    Task<int> CountLikesAsync(long postId);
    Task<Like> LikePostAsync(LikePostDto likeDto);
    Task UnLikePostAsync(UnLikePostDto unLikePostDto);
    Task<bool> IsPostLikedAsync(IsPostLikedDto isPostLikedDto);
    Task DeleteAsync(long postId);

}