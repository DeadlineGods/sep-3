using System.Text.Json;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class AdminHttpClient : IAdminService
{
    private readonly HttpClient client;

    public AdminHttpClient(HttpClient client)
    {
        this.client = client;
    }
    
    public async Task<Admin> GetAsync(string identityName)
    {
        HttpResponseMessage response = await client.GetAsync("https://localhost:7196/Admin");

        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        Admin admin = JsonSerializer.Deserialize<Admin>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return admin;
    }
}