namespace HttpClients.Implementations;

public class PostHttpClient
{
    private HttpClient client;

    public PostHttpClient(HttpClient client)
    {
        this.client = client;
    }
}