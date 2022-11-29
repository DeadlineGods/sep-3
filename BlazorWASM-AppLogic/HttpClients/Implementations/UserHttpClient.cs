using System.Net.Http.Json;
using System.Runtime.CompilerServices;
using System.Text.Json;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class UserHttpClient : IUserService
{
    private readonly HttpClient client;

    public UserHttpClient(HttpClient client)
    {
        this.client = client;
    }
    public async Task<User> Create(UserAuthDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("/users", dto);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        User user = JsonSerializer.Deserialize<User>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return user;
    }

    public async Task<IEnumerable<User>> GetUsers(string? usernameContains, long? userid)
    {
        string uri = "https://localhost:7196/users";
        if (!string.IsNullOrEmpty(usernameContains))
        {
            uri += $"?username={usernameContains}";
        }

        if (userid != null)
        {
            uri += string.IsNullOrEmpty(uri) ? "?" : "&";
            uri += $"userid={userid}";
        }

        HttpResponseMessage response = await client.GetAsync(uri);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        IEnumerable<User> users = JsonSerializer.Deserialize<IEnumerable<User>>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return users;
    }

    public async Task<Like> LikePost(LikePostDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("/likes", dto);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }
        Like like = JsonSerializer.Deserialize<Like>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return like;
    }

    public async Task<IEnumerable<User>> GetLikes(int postId)
    {
        HttpResponseMessage response = await client.GetAsync("User/Like");
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }
        IEnumerable<User> users = JsonSerializer.Deserialize<IEnumerable<User>>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return users;
    }

    public async Task<int> CountLikes(int postId)
    {
        HttpResponseMessage response = await client.GetAsync("User/likes/count");
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        int count = JsonSerializer.Deserialize<int>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return count;
    }
}