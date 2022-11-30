using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class LikeHttpClient : ILikeService
{
    private readonly HttpClient client;

    public LikeHttpClient(HttpClient client)
    {
        this.client = client;
    }
    
    public async Task<Like> LikePostAsync(LikePostDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("https://localhost:7196/Like/like", dto);
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

    public async Task UnLikePostAsync(UnLikePostDto unLikePostDto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("https://localhost:7196/Like/unlike", unLikePostDto);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }
    }

    public async Task<bool> IsPostLikedAsync(IsPostLikedDto isPostLikedDto)
    {
        string URI = "https://localhost:7196/Like/is-liked" + ConstructQuery(isPostLikedDto);
        
        HttpResponseMessage response = await client.GetAsync(URI);
        string result = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(result);
        }

        bool count = JsonSerializer.Deserialize<bool>(result, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;
        return count;
    }

    public async Task<int> CountLikesAsync(int postId)
    {
        HttpResponseMessage response = await client.GetAsync("https://localhost:7196/Like/likes");
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
    private string ConstructQuery(IsPostLikedDto isPostLikedDto)
    {
        string query = "";

        query += "?postId=" + isPostLikedDto.postId;
        
        query += "&userId=" + isPostLikedDto.userId;

        return query;
    }
}