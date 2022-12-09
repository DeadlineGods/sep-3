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

    public async Task<IEnumerable<Admin>> GetAsync(string identityName)
    {
        HttpResponseMessage response = await client.GetAsync("https://localhost:7196/Admin?username=" + identityName);

        string content = await response.Content.ReadAsStringAsync();
        if (!response.IsSuccessStatusCode)
        {
            throw new Exception(content);
        }

        IEnumerable<Admin> admin = JsonSerializer.Deserialize<IEnumerable<Admin>>(content, new JsonSerializerOptions
        {
            PropertyNameCaseInsensitive = true
        })!;

        return admin;
    }
}
