using Application.DAOsInterfaces;
using Application.GrpcClients;
using Application.Logic;
using Application.LogicInterfaces;
using Domain.DTOs;

namespace ApplicationXUnitTest;

public class LikeLogicTest
{
    private readonly ITestLogic TestLogic;
    private readonly ILikeLogic LikeLogic;
    private readonly ILikeDao LikeDao;
    private readonly IPostDao PostDao;
    private readonly IUserDao UserDao;
    private readonly ILocationDao LocationDao;

    public LikeLogicTest()
    {
        LocationDao = new LocationGrpcClient();
        UserDao = new UserGrpcClient();
        LikeDao = new LikeGrpcClient();
        PostDao = new PostGrpcClient(UserDao, LocationDao);
        
        TestLogic = new TestLogic();
        LikeLogic = new LikeLogic(UserDao, PostDao, LikeDao);
    }

    private async Task SetupDatabaseAsync()
    {
        await TestLogic.RestartDatabaseAsync();
        await TestLogic.SwitchToTestDatabaseAsync();
    }

    [Fact]
    public async Task LikePost()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            LikePostDto likePostDto = new LikePostDto(2, 2);
            await LikeLogic.LikePostAsync(likePostDto);

            int likeCount = await LikeLogic.CountLikesAsync(2);
            
            // Assert
            Assert.Equal(1, likeCount);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task UnLikePost()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            UnLikePostDto unLikePostDto = new UnLikePostDto(1, 1);
            await LikeLogic.UnLikePostAsync(unLikePostDto);

            int likeCount = await LikeLogic.CountLikesAsync(1);
            
            // Assert
            Assert.Equal(1, likeCount);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task IsPostLikedTrue()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            IsPostLikedDto isPostLikedDto = new IsPostLikedDto(1, 2);
            bool isLiked = await LikeLogic.IsPostLikedAsync(isPostLikedDto);
            
            // Assert
            Assert.True(isLiked);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task IsPostLikedFalse()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            IsPostLikedDto isPostLikedDto = new IsPostLikedDto(2, 2);
            bool isLiked = await LikeLogic.IsPostLikedAsync(isPostLikedDto);
            
            // Assert
            Assert.False(isLiked);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
}