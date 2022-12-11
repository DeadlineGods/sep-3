using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Grpc.Net.Client;
using GrpcClient;

namespace Application.Logic;

public class TestLogic : ITestLogic
{
    public async Task RestartDatabaseAsync()
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new TestService.TestServiceClient(channel);

        var reply = await client.RestartDatabaseAsync(new EmptyTest());
    }

    public async Task SwitchToTestDatabaseAsync()
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new TestService.TestServiceClient(channel);

        var reply = await client.SwitchToTestDatabaseAsync(new EmptyTest());
    }

    public async Task SwitchToProductionDatabaseAsync()
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        var client = new TestService.TestServiceClient(channel);

        var reply = await client.SwitchToProductionDatabaseAsync(new EmptyTest());
    }
}