using Application.DAOsInterfaces;
using Application.GrpcClients;
using Application.Logic;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace ApplicationXUnitTest;

public class LocationLogicTest
{
    private readonly ITestLogic TestLogic;
    private readonly ILocationLogic LocationLogic;
    private readonly ILocationDao LocationDao;

    public LocationLogicTest()
    {
        LocationDao = new LocationGrpcClient();
        
        TestLogic = new TestLogic();
        LocationLogic = new LocationLogic(LocationDao);
    }
    
    private async Task SetupDatabaseAsync()
    {
        await TestLogic.RestartDatabaseAsync();
        await TestLogic.SwitchToTestDatabaseAsync();
    }
    
    [Fact]
    public async Task Create()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            LocationCreationDto locationCreationDto1 = new LocationCreationDto(
                "Gladsaxe Møllevej 48",
                "Copenhagen",
                "2860" ,
                Country.DK,
                new Coordinate(55.7379415, 12.47492)
            );
            int id = await LocationLogic.CreateAsync(locationCreationDto1); 

            // Assert
            Assert.Equal(2, id);
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
            Location location = await LocationLogic.GetAsync(1);

            // Assert
            Assert.Equal(55.8581310000, location.coordinate.latitude);
            Assert.Equal(9.8475880000, location.coordinate.longitude);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task GetCoordinates()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            Coordinate coordinate = await LocationLogic.GetCoordinatesAsync(1);

            // Assert
            Assert.Equal(55.8581310000, coordinate.latitude);
            Assert.Equal(9.8475880000, coordinate.longitude);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
}