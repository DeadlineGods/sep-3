using System.Text;
using System.Text.Json;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class CommentHttpClient : ICommentService
{
    private HttpClient client;

    public CommentHttpClient(HttpClient client)
    {
        this.client = client;
    }
    
    public async Task<ICollection<Comment>> GetCommentsByPostAsync(long id)
    {
        HttpResponseMessage response = await client.GetAsync("https://localhost:7196/Comments?postId=" + id);

        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        ICollection<Comment> comments = JsonSerializer.Deserialize<ICollection<Comment>>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return comments;
    }

    public async Task<ICollection<Comment>> GetAllSubCommentsAsync(long commentId)
    {
        HttpResponseMessage response = await client.GetAsync("https://localhost:7196/sub-comments?id=" + commentId);

        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        ICollection<Comment> comments = JsonSerializer.Deserialize<ICollection<Comment>>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return comments;
    }

    public async Task<long> CreateAsync(string body, long ownerId, long commentPostId)
    {
        CommentCreationDto creationDto = new CommentCreationDto(ownerId, commentPostId, body);
        
        string subFormAsJson = JsonSerializer.Serialize(creationDto);
        StringContent content = new(subFormAsJson, Encoding.UTF8, "application/json");
        
        HttpResponseMessage response = await client.PostAsync("https://localhost:7196/Comments", content);
        string responseContent = await response.Content.ReadAsStringAsync();
		
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(responseContent);
        }
        
        return long.Parse(responseContent);
    }

    public async Task AssignCommentToParentAsync(long commentId, long parentCommentId)
    {
        AssignCommentToDto assignCommentToDto = new AssignCommentToDto(commentId, parentCommentId);
        string subFormAsJson = JsonSerializer.Serialize(assignCommentToDto);
        StringContent content = new(subFormAsJson, Encoding.UTF8, "application/json");
        HttpResponseMessage response = await client.PostAsync("https://localhost:7196/assign", content);
        string responseContent = await response.Content.ReadAsStringAsync();
		
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(responseContent);
        }
    }
}