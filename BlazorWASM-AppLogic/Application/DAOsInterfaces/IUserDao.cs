using Domain.DTOs;
using Domain.Models;

namespace Application.DAOsInterfaces;

public interface IUserDao
{
    public Task<IEnumerable<User>> GetAsync(SearchUserParametersDto searchParameters);
    Task<User> CreateAsync(UserCreationDto user);
    Task<Like> LikePost(LikePostDto likeDto);
    Task<IEnumerable<User>> GetLikes(int postId);
    Task<int> CountLikesAsync(int postId);
}
