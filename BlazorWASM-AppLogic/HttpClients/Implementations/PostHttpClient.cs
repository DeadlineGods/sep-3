using System.Text;
using System.Text.Json;
using Domain.DTOs;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class PostHttpClient : IPostService
{
    private HttpClient client;

    public PostHttpClient(HttpClient client)
    {
        this.client = client;
    }

    public async Task CreateAsync(PostCreationDto postCreationDto)
    {
        string subFormAsJson = JsonSerializer.Serialize(postCreationDto);
        StringContent content = new(subFormAsJson, Encoding.UTF8, "application/json");

        HttpResponseMessage response = await client.PostAsync("http://localhost:5196/posts/create", content);
        string responseContent = await response.Content.ReadAsStringAsync();

        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(responseContent);
        }
    }
}
