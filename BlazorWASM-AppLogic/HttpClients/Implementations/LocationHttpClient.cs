using System.Text.Json;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class LocationHttpClient : ILocationService
{
	private HttpClient client;

	public LocationHttpClient(HttpClient client)
	{
		this.client = client;
	}

	public async Task<Location> GetAsync(int id)
	{

		HttpResponseMessage response = await client.GetAsync("https://localhost:7196/Location/get?id=" + id);

		string content = await response.Content.ReadAsStringAsync();
		if (!response.IsSuccessStatusCode)
		{
			throw new Exception(content);
		}

		Location location = JsonSerializer.Deserialize<Location>(content, new JsonSerializerOptions
		{
			PropertyNameCaseInsensitive = true
		})!;

		return location;
	}

	public async Task<Coordinate> GetCoordinatesAsync(int id)
	{
		HttpResponseMessage response = await client.GetAsync("https://localhost:7196/Location/get-coordinates?id=" + id);

		string content = await response.Content.ReadAsStringAsync();
		if (!response.IsSuccessStatusCode)
		{
			throw new Exception(content);
		}

		Coordinate coordinate = JsonSerializer.Deserialize<Coordinate>(content, new JsonSerializerOptions
		{
			PropertyNameCaseInsensitive = true
		})!;

		return coordinate;
	}
}
