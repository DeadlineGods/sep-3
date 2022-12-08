using System.Text;
using System.Text.Json;
using Domain.DTOs;
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

	public async Task<int> CreateAsync(LocationCreationDto dto)
	{

		string subFormAsJson = JsonSerializer.Serialize(dto);
		StringContent content = new(subFormAsJson, Encoding.UTF8, "application/json");

		HttpResponseMessage response = await client.PostAsync("https://localhost:7196/location/create", content);
		string responseContent = await response.Content.ReadAsStringAsync();

		if (!response.IsSuccessStatusCode)
		{
			throw new Exception(responseContent);
		}

		return Int32.Parse(responseContent);
	}

	private async Task<LocationCreationDto> GetAddressFromCoordinates(Coordinate coordinate)
	{

		HttpResponseMessage response = await client.GetAsync($"https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&key=AIzaSyBWOfx3pXBNiaG9aRvUjhHfFV8NqEZlsio");
		string responseContent = await response.Content.ReadAsStringAsync();

		Console.WriteLine(responseContent);
		Console.WriteLine("aa");

		if (!response.IsSuccessStatusCode)
		{
			throw new Exception(responseContent);
		}

		Object obj = JsonSerializer.Deserialize<Object>(responseContent, new JsonSerializerOptions
		{
			PropertyNameCaseInsensitive = true
		})!;

		Console.WriteLine(obj);

		return null;
	}


}
