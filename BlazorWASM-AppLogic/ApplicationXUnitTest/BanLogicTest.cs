using Application.DAOsInterfaces;
using Application.GrpcClients;
using Application.Logic;
using Application.LogicInterfaces;
using Domain.DTOs;

namespace ApplicationXUnitTest;

public class BanLogicTest
{
    private readonly ITestLogic TestLogic;
    private readonly IBanLogic BanLogic;
    private readonly IBanDao BanDao;

    public BanLogicTest()
    {
        BanDao = new BanGrpcClient();
        
        TestLogic = new TestLogic();
        BanLogic = new BanLogic(BanDao);
    }
    
    private async Task SetupDatabaseAsync()
    {
        await TestLogic.RestartDatabaseAsync();
        await TestLogic.SwitchToTestDatabaseAsync();
    }
    
    [Fact]
    public async Task CreatePostId1()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            BanCreationDto banCreationDto = new BanCreationDto()
            {
                Reason = "Broke community guide lines",
                Admin = "admin",
                PostId = 2
            };
            long id = await BanLogic.CreateAsync(banCreationDto);

            // Assert
            Assert.Equal(2, id);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task CreatePostId2()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            BanCreationDto banCreationDto = new BanCreationDto()
            {
                Reason = "Broke community guide lines",
                Admin = "admin",
                PostId = 1
            };
            long id = await BanLogic.CreateAsync(banCreationDto);

            // Assert
            Assert.Equal(1, id);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task Get1()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            long id = await BanLogic.GetAsync(1);

            // Assert
            Assert.Equal(1, id);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task Get2()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            BanCreationDto banCreationDto = new BanCreationDto()
            {
                Reason = "Broke community guide lines",
                Admin = "admin",
                PostId = 2
            };
            await BanLogic.CreateAsync(banCreationDto);
            long id = await BanLogic.GetAsync(2);

            // Assert
            Assert.Equal(2, id);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
}