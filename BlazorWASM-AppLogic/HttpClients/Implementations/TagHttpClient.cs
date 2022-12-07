using System.Text;
using System.Text.Json;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class TagHttpClient : ITagService
{
    private HttpClient client;

    public TagHttpClient(HttpClient client)
    {
        this.client = client;
    }

    public async Task<string[]> CreateAsync(PostTagCreationDto dto)
    {
        string subFormAsJson = JsonSerializer.Serialize(dto);
        StringContent content = new(subFormAsJson, Encoding.UTF8, "application/json");
        
        HttpResponseMessage response = await client.PostAsync("https://localhost:7196/Tag/create", content);
        string responseContent = await response.Content.ReadAsStringAsync();
        
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(responseContent);
        }
        var toReturn = responseContent.ToCharArray().Select( c => c.ToString()).ToArray();
        return toReturn;
    }
    
    public async Task<ICollection<TagPost>> GetPostTagAsync(long? postId = null, string? tagContains = null)
    {
        string query = ConstructQuery(postId, tagContains);
        HttpResponseMessage response = await client.GetAsync("https://localhost:7196/Tag/getPostTag" + query);

        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        Console.WriteLine(content);
        ICollection<TagPost> tags = JsonSerializer.Deserialize<ICollection<TagPost>>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return tags;
    }
    public async Task<ICollection<Tag>> GetTagListAsync(string? tagContains = null)
    {
        string query = ConstructQuery(null, tagContains);
        HttpResponseMessage response = await client.GetAsync("https://localhost:7196/Tag/getTagList" + query);

        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        Console.WriteLine(content);
        ICollection<Tag> tags = JsonSerializer.Deserialize<ICollection<Tag>>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return tags;
    }

    private static string ConstructQuery(long? postId, string? tagContains)
    {
        string query = "";

        if (postId != null)
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"postId={postId}";
        }

        if (!string.IsNullOrEmpty(tagContains))
        {
            query += string.IsNullOrEmpty(query) ? "?" : "&";
            query += $"TagContains={tagContains}";
        }

        return query;
    }
    
    public async Task DeleteAsync(long postId)
    {

        HttpResponseMessage response = await client.DeleteAsync($"https://localhost:7196/Tag/{postId}");
        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

    }
}