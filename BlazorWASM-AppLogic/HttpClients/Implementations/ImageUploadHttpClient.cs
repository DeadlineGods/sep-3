using System.Text;
using System.Text.Json;
using HttpClients.ClientInterfaces;
using Shared;

namespace HttpClients.Implementations;

public class ImageUploadHttpClient : IImageUploadService
{
    private HttpClient client;

    public ImageUploadHttpClient(HttpClient client)
    {
        this.client = client;
    }
    
    public async Task<string> UploadAsync(ImageFile imageFile)
    {
        string subFormAsJson = JsonSerializer.Serialize(imageFile);
        StringContent content = new(subFormAsJson, Encoding.UTF8, "application/json");

        HttpResponseMessage response = await client.PostAsync("https://localhost:7174/", content);
        string responseContent = await response.Content.ReadAsStringAsync();

        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(responseContent);
        }

        return responseContent;
    }
}