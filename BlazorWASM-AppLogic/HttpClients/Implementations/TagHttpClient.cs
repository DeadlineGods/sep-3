using System.Text.Json;
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

    public async Task<ICollection<TagPost>> GetAsync(int? postId = null, string? tagContains = null)
    {
        string query = ConstructQuery(postId, tagContains);
        HttpResponseMessage response = await client.GetAsync("https://localhost:7196/Tags/get" + query);

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
    private static string ConstructQuery(int? postId, string? tagContains)
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
            query += $"tagContains={tagContains}";
        }

        return query;
    }
}