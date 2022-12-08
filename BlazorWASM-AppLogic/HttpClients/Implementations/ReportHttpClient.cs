using System.Net.Http.Json;
using System.Text.Json;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;

namespace HttpClients.Implementations;

public class ReportHttpClient : IReportService
{
	private readonly HttpClient client;

	public ReportHttpClient(HttpClient client)
	{
		this.client = client;
	}
	public async Task<int> ReportPostAsync(ReportPostDto dto)
	{
		HttpResponseMessage response = await client.PostAsJsonAsync("https://localhost:7196/Report/", dto);
		string result = await response.Content.ReadAsStringAsync();

		if (!response.IsSuccessStatusCode)
		{
			throw new Exception(result);
		}

		int id = JsonSerializer.Deserialize<int>(result, new JsonSerializerOptions
		{
			PropertyNameCaseInsensitive = true
		})!;
		return id;
	}

	public async Task<Report> GetReportById(long reportId)
	{
		HttpResponseMessage response = await client.GetAsync("https://localhost:7196/Report/get?reportId=" + reportId);

		string content = await response.Content.ReadAsStringAsync();
		if (!response.IsSuccessStatusCode)
		{
			throw new Exception(content);
		}

		Report report = JsonSerializer.Deserialize<Report>(content, new JsonSerializerOptions
		{
			PropertyNameCaseInsensitive = true
		})!;

		return report;
	}

	public async Task<IEnumerable<Report>> GetAsync()
	{
		HttpResponseMessage response = await client.GetAsync("https://localhost:7196/Report");

		string content = await response.Content.ReadAsStringAsync();
		if (!response.IsSuccessStatusCode)
		{
			throw new Exception(content);
		}

		IEnumerable<Report> comments = JsonSerializer.Deserialize<IEnumerable<Report>>(content, new JsonSerializerOptions
		{
			PropertyNameCaseInsensitive = true
		})!;

		return comments;
	}
}
