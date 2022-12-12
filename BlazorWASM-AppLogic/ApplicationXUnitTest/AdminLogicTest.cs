using Application.DAOsInterfaces;
using Application.GrpcClients;
using Application.Logic;
using Application.LogicInterfaces;
using Domain.Models;

namespace ApplicationXUnitTest;

public class AdminLogicTest
{
    private readonly ITestLogic TestLogic;
    private readonly IAdminLogic AdminLogic;
    private readonly IAdminDao AdminDao;
    
    public AdminLogicTest()
    {
        AdminDao = new AdminGrpcClient();
        
        TestLogic = new TestLogic();
        AdminLogic = new AdminLogic(AdminDao);
    }
    
    private async Task SetupDatabaseAsync()
    {
        await TestLogic.RestartDatabaseAsync();
        await TestLogic.SwitchToTestDatabaseAsync();
    }
    
    [Fact]
    public async Task GetByUsername()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            IEnumerable<Admin> comments = await AdminLogic.GetAsync("admin");

            // Assert
            Assert.Single(comments);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task Get()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            IEnumerable<Admin> comments = await AdminLogic.GetAsync(null);

            // Assert
            Assert.Single(comments);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }

}