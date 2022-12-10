using System.Security.Claims;
using Domain.DTOs;
using Domain.Models;

namespace BlazorWasm.Services;

public interface IAuthService
{
    public Task LoginAsync(string username, string password);
    public Task LoginAdminAsync(string username, string password);
    public Task LogoutAsync();
    public Task RegisterAsync(UserCreationDto dto);
    public Task<ClaimsPrincipal> GetAuthAsync();
    public Task<long> GetLoggedUserId();

    public Action<ClaimsPrincipal> OnAuthStateChanged { get; set; }
}
