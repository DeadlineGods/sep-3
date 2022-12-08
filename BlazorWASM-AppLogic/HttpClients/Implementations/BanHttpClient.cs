using System.Text;
using System.Text.Json;
using Domain.DTOs;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class BanHttpClient : IBanService
{
    private HttpClient client;

    public BanHttpClient(HttpClient client)
    {
        this.client = client;
    }
    
    public async Task CrateAsync(BanCreationDto dto)
    {
        string subFormAsJson = JsonSerializer.Serialize(dto);
        StringContent content = new(subFormAsJson, Encoding.UTF8, "application/json");

        HttpResponseMessage response = await client.PostAsync("https://localhost:7196/Ban", content);
        string responseContent = await response.Content.ReadAsStringAsync();

        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(responseContent);
        }
    }
}