namespace Application.LogicInterfaces;

public interface ITestLogic
{
    Task RestartDatabaseAsync();
    Task SwitchToTestDatabaseAsync();
    Task SwitchToProductionDatabaseAsync();
}