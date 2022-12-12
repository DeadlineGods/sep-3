using System.Collections;
using Application.DAOsInterfaces;
using Application.GrpcClients;
using Application.Logic;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace ApplicationXUnitTest;

public class UserLogicTest
{
    private readonly ITestLogic TestLogic;
    private readonly IUserLogic UserLogic;
    private readonly IUserDao UserDao;

    public UserLogicTest()
    {
        UserDao = new UserGrpcClient();

        TestLogic = new TestLogic();
        UserLogic = new UserLogic(UserDao);
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
            SearchUserParametersDto searchParameters = new SearchUserParametersDto("Mira");
            IEnumerable<User> users = await UserLogic.GetAsync(searchParameters);

            // Assert
            Assert.Single(users);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }

    [Fact]
    public async Task GetById()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            SearchUserParametersDto searchParameters = new SearchUserParametersDto(null, 2);
            IEnumerable<User> users = await UserLogic.GetAsync(searchParameters);

            // Assert
            Assert.Single(users);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }

    [Fact]
    public async Task GetLikes()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            IEnumerable<User> users = await UserLogic.GetLikes(1);

            // Assert
            Assert.Equal(2, users.Count());
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }

    [Fact]
    public async Task Create()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            UserCreationDto usersCreationDto = new UserCreationDto(
                "Test",
                "123",
                "Testo",
                "Testovic",
                "TestoTestovic@gmail.com",
                "+4567345687",
                1);
            User user = await UserLogic.CreateAsync(usersCreationDto);

            // Assert
            Assert.Equal(3, user.Id);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
}