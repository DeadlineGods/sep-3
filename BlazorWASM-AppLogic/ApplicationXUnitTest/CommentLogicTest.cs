using Application.DAOsInterfaces;
using Application.GrpcClients;
using Application.Logic;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace ApplicationXUnitTest;

public class CommentLogicTest
{
    private readonly ITestLogic TestLogic;
    private readonly ICommentLogic CommentLogic;
    private readonly ICommentDao CommentDao;
    private readonly IPostDao PostDao;
    private readonly IUserDao UserDao;
    private readonly ILocationDao LocationDao;

    public CommentLogicTest()
    {
        LocationDao = new LocationGrpcClient();
        UserDao = new UserGrpcClient();
        PostDao = new PostGrpcClient(UserDao, LocationDao);
        CommentDao = new CommentGrpcClient(UserDao, PostDao);

        TestLogic = new TestLogic();
        CommentLogic = new CommentLogic(CommentDao, UserDao, PostDao);
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
            CommentCreationDto creationDto = new CommentCreationDto(1, 1, "New Comment");
            long id = await CommentLogic.CreateAsync(creationDto);

            // Assert
            Assert.Equal(6, id);
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
            IEnumerable<Comment> comments = await CommentLogic.GetAsync(1);

            // Assert
            Assert.Equal(2, comments.Count());
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
            Comment comment = await CommentLogic.GetByIdAsync(2);

            // Assert
            Assert.Equal("Nice", comment.Body);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }

    [Fact]
    public async Task GetSubComments()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            IEnumerable<Comment> comments = await CommentLogic.GetSubCommentsAsync(3);

            // Assert
            Assert.Single(comments);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }


    [Fact]
    public async Task AssignCommentToParent()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            CommentCreationDto creationDto = new CommentCreationDto(1, 1, "New Comment");
            long id = await CommentLogic.CreateAsync(creationDto);

            AssignCommentToDto assignCommentToDto = new AssignCommentToDto(id, 3);
            await CommentLogic.AssignCommentToParentAsync(assignCommentToDto);

            IEnumerable<Comment> comments = await CommentLogic.GetSubCommentsAsync(3);

            // Assert
            Assert.Equal(2, comments.Count());
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
}