using Application.DAOsInterfaces;
using Application.GrpcClients;
using Application.Logic;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace ApplicationXUnitTest;


public class ReportLogicTest
{
    private readonly ITestLogic TestLogic;
    private readonly IReportLogic ReportLogic;
    private readonly IBanLogic BanLogic;
    private readonly IReportDao ReportDao;
    private readonly IPostDao PostDao;
    private readonly IUserDao UserDao;
    private readonly ILocationDao LocationDao;
    private readonly IBanDao BanDao;
    public ReportLogicTest()
    {
        BanDao = new BanGrpcClient();
        LocationDao = new LocationGrpcClient();
        UserDao = new UserGrpcClient();
        PostDao = new PostGrpcClient(UserDao, LocationDao);
        ReportDao = new ReportGrpcClient(UserDao, PostDao);
        BanLogic = new BanLogic(BanDao);

        TestLogic = new TestLogic();
        ReportLogic = new ReportLogic(UserDao, PostDao, ReportDao, BanLogic);
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
            ReportPostDto reportPostDto = new ReportPostDto("Not up to community guide standards", 1, 1);
            long id = await ReportLogic.ReportPostAsync(reportPostDto);
            
            // Assert
            Assert.Equal(2, id);
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
            Report report = await ReportLogic.GetByIdAsync(1);
            
            // Assert
            Assert.Equal(1, report.reportId);
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
            ReportPostDto reportPostDto = new ReportPostDto("Not up to community guide standards", 1, 1);
            await ReportLogic.ReportPostAsync(reportPostDto);
            
            // Act
            IEnumerable<Report> reports = await ReportLogic.GetAsync();
            
            // Assert
            Assert.Equal(2, reports.Count());
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
}