using System.Collections;
using Application.DAOsInterfaces;
using Application.GrpcClients;
using Application.Logic;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace ApplicationXUnitTest;

public class TagLogicTest
{
    private readonly ITestLogic TestLogic;
    private readonly ITagLogic TagLogic;
    private readonly ITagDao TagDao;
    private readonly IPostDao PostDao;
    private readonly IUserDao UserDao;
    private readonly ILocationDao LocationDao;

    public TagLogicTest()
    {
        LocationDao = new LocationGrpcClient();
        UserDao = new UserGrpcClient();
        PostDao = new PostGrpcClient(UserDao, LocationDao);
        TagDao = new TagGrpcClient(PostDao);
        
        TestLogic = new TestLogic();
        TagLogic = new TagLogic(TagDao);
    }
    
    private async Task SetupDatabaseAsync()
    {
        await TestLogic.RestartDatabaseAsync();
        await TestLogic.SwitchToTestDatabaseAsync();
    }
    
    [Fact]
    public async Task CreateLength()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            PostTagCreationDto postTagCreationDto = new PostTagCreationDto(1, new []{"test1", "test2", "test3"});
            string[] tags = await TagLogic.CreateAsync(postTagCreationDto);

            // Assert
            Assert.Equal(3, tags.Length);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task CreateGetElement()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            PostTagCreationDto postTagCreationDto = new PostTagCreationDto(1, new []{"test1", "test2", "test3"});
            string[] tags = await TagLogic.CreateAsync(postTagCreationDto);

            // Assert
            Assert.Equal("test2", tags[1]);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task GetPostTagsByTagContains()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();
            PostTagCreationDto postTagCreationDto = new PostTagCreationDto(1, new []{"test1", "test2", "test3"});
            await TagLogic.CreateAsync(postTagCreationDto);
            
            // Act
            SearchPostTagParameters searchPostTagParameters = new SearchPostTagParameters("test");
            IEnumerable<TagPost> tagPosts = await TagLogic.GetPostTagAsync(searchPostTagParameters);

            // Assert
            Assert.Equal(3, tagPosts.Count());
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task GetPostTagsByPostId()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();
            PostTagCreationDto postTagCreationDto = new PostTagCreationDto(1, new []{"test1", "test2", "test3"});
            await TagLogic.CreateAsync(postTagCreationDto);
            
            // Act
            SearchPostTagParameters searchPostTagParameters = new SearchPostTagParameters(null, 1);
            IEnumerable<TagPost> tagPosts = await TagLogic.GetPostTagAsync(searchPostTagParameters);

            // Assert
            Assert.Equal(4, tagPosts.Count());
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task GetTagList()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();
            PostTagCreationDto postTagCreationDto = new PostTagCreationDto(1, new []{"test1", "test2", "test3"});
            await TagLogic.CreateAsync(postTagCreationDto);
            
            // Act
            SearchTagListParameters searchTagListParameters = new SearchTagListParameters("test");
            IEnumerable<Tag> tags = await TagLogic.GetTagListAsync(searchTagListParameters);

            // Assert
            Assert.Equal(3, tags.Count());
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task Delete()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();
            PostTagCreationDto postTagCreationDto = new PostTagCreationDto(2, new []{"test1", "test2", "test3"});
            await TagLogic.CreateAsync(postTagCreationDto);
            
            // Act
            await TagLogic.DeleteTask(2);
            SearchPostTagParameters searchPostTagParameters = new SearchPostTagParameters(null, 2);
            IEnumerable<TagPost> tagPosts = await TagLogic.GetPostTagAsync(searchPostTagParameters);
            // Assert
            Assert.Empty(tagPosts);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
}