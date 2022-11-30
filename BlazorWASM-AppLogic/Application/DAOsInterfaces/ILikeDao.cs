﻿using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface ILikeDao
{
    Task<int> CountLikesAsync(int postId);
    Task<Like> LikePostAsync(LikePostDto likeDto);
    Task UnLikePostAsync(UnLikePostDto unLikePostDto);
    Task<bool> IsPostLikedAsync(IsPostLikedDto isPostLikedDto);
}