using System.Net.Http.Json;
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
    public async Task<User> Create(UserCreationDto dto)
    {
        HttpResponseMessage response = await client.PostAsJsonAsync("https://localhost:7196/user", dto);
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

    public async Task<IEnumerable<User>> GetUsersAsync(string? usernameContains, long? userid)
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

        IEnumerable<User> users = new List<User>();
        if (response.IsSuccessStatusCode)
        {
            // throw new Exception(result);
	        users = JsonSerializer.Deserialize<IEnumerable<User>>(result, new JsonSerializerOptions
	        {
	            PropertyNameCaseInsensitive = true
	        })!;
        }

        return users;
    }
}
