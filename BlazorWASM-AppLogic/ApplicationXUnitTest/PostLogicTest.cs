using Application.DAOsInterfaces;
using Application.GrpcClients;
using Application.Logic;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Microsoft.Extensions.DependencyInjection;
using Moq;

namespace ApplicationXUnitTest;

public class PostLogicTest
{
    private readonly ITestLogic TestLogic;
    private readonly IPostLogic PostLogic;

    private readonly IUserDao UserDao;
    private readonly ILikeDao LikeDao;
    private readonly ILocationDao LocationDao;
    private readonly IPostDao PostDao;
    private readonly ICommentDao CommentDao;
    private readonly ITagDao TagDao;

    public PostLogicTest()
    {
        UserDao = new UserGrpcClient();
        LikeDao = new LikeGrpcClient();
        LocationDao = new LocationGrpcClient();

        PostDao = new PostGrpcClient(UserDao, LocationDao);
        CommentDao = new CommentGrpcClient(UserDao, PostDao);
        TagDao = new TagGrpcClient(PostDao);

        TestLogic = new TestLogic();
        PostLogic = new PostLogic(
            PostDao,
            UserDao,
            LikeDao,
            LocationDao,
            CommentDao,
            TagDao);
    }

    private async Task SetupDatabaseAsync()
    {
        await TestLogic.RestartDatabaseAsync();
        await TestLogic.SwitchToTestDatabaseAsync();
    }
    
    [Fact]
    public async Task CreatePost()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            PostCreationDto postCreationDto = new PostCreationDto("Test Post", 1, "Test Description", "image.png", 1);
            long id = await PostLogic.CreateAsync(postCreationDto);

            // Assert
            Assert.Equal(3, id);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task GetAllPost()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            SearchPostParametersDto searchPostParametersDto = new SearchPostParametersDto();
            IEnumerable<Post> posts = await PostLogic.GetAsync(searchPostParametersDto);
            
            // Assert
            Assert.Equal(2, posts.Count());
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task GetByIdPost()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            SearchPostParametersDto searchPostParametersDto = new SearchPostParametersDto(1);
            IEnumerable<Post> posts = await PostLogic.GetAsync(searchPostParametersDto);
            
            // Assert
            Assert.Single(posts);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task GetByUserIdPost()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();
            PostCreationDto postCreationDto1 = new PostCreationDto("Test Post", 2, "Test Description", "image.png", 1);
            PostCreationDto postCreationDto2 = new PostCreationDto("Test Post1", 2, "Test Description", "image.png", 1);
            PostCreationDto postCreationDto3 = new PostCreationDto("Test Post2", 2, "Test Description", "image.png", 1);
            await PostLogic.CreateAsync(postCreationDto1);
            await PostLogic.CreateAsync(postCreationDto2);
            await PostLogic.CreateAsync(postCreationDto3);
            
            
            // Act
            SearchPostParametersDto searchPostParametersDto = new SearchPostParametersDto(null, 2);
            IEnumerable<Post> posts = await PostLogic.GetAsync(searchPostParametersDto);
            
            // Assert
            Assert.Equal(3, posts.Count());
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task GetByTitleContains()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();
            PostCreationDto postCreationDto = new PostCreationDto("Unique name", 1, "Test Description", "image.png", 1);
            await PostLogic.CreateAsync(postCreationDto);
            
            
            // Act
            SearchPostParametersDto searchPostParametersDto = new SearchPostParametersDto(null, null, "Unique name");
            IEnumerable<Post> posts = await PostLogic.GetAsync(searchPostParametersDto);
            
            // Assert
            Assert.Single(posts);
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

            // Act
            await PostLogic.DeleteAsync(1, 1);
            
            SearchPostParametersDto searchPostParametersDto = new SearchPostParametersDto();
            IEnumerable<Post> posts = await PostLogic.GetAsync(searchPostParametersDto);
            
            // Assert
            Assert.Single(posts);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task GetInRadius1()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();
            LocationCreationDto locationCreationDto1 = new LocationCreationDto(
                "Gladsaxe Møllevej 48",
                "Copenhagen",
                "2860" ,
                Country.DK,
                new Coordinate(55.7379415, 12.47492)
                );
            LocationCreationDto locationCreationDto2 = new LocationCreationDto(
                "Tobaksvejen 33",
                "Copenhagen",
                "2860" ,
                Country.DK,
                new Coordinate(55.7387445, 12.4755684)
            );
            await LocationDao.CreateAsync(locationCreationDto1); 
            await LocationDao.CreateAsync(locationCreationDto2); 
            
            PostCreationDto postCreationDto1 = new PostCreationDto("Test Post", 2, "Test Description", "image.png", 2);
            PostCreationDto postCreationDto2 = new PostCreationDto("Test Post1", 2, "Test Description", "image.png", 2);
            await PostLogic.CreateAsync(postCreationDto1);
            await PostLogic.CreateAsync(postCreationDto2);
            
            // Act
            Coordinate coordinate = new Coordinate(55.7365619, 12.4687560);
            IEnumerable<Post> posts = await PostLogic.GetInRadiusAsync(coordinate, 10);
            
            // Assert
            Assert.Equal(2, posts.Count());
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task GetInRadius2()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();
            LocationCreationDto locationCreationDto1 = new LocationCreationDto(
                "Gladsaxe Møllevej 48",
                "Copenhagen",
                "2860" ,
                Country.DK,
                new Coordinate(55.7379415, 12.47492)
            );
            LocationCreationDto locationCreationDto2 = new LocationCreationDto(
                "Tobaksvejen 33",
                "Copenhagen",
                "2860" ,
                Country.DK,
                new Coordinate(55.7387445, 12.4755684)
            );
            await LocationDao.CreateAsync(locationCreationDto1); 
            await LocationDao.CreateAsync(locationCreationDto2); 
            
            PostCreationDto postCreationDto1 = new PostCreationDto("Test Post", 2, "Test Description", "image.png", 2);
            PostCreationDto postCreationDto2 = new PostCreationDto("Test Post1", 2, "Test Description", "image.png", 2);
            await PostLogic.CreateAsync(postCreationDto1);
            await PostLogic.CreateAsync(postCreationDto2);
            
            // Act
            Coordinate coordinate = new Coordinate(55.8581310000, 9.8475880000);
            IEnumerable<Post> posts = await PostLogic.GetInRadiusAsync(coordinate, 10);
            
            // Assert
            Assert.Equal(2, posts.Count());
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task UpdateTitle()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            UpdatePostDto updatePostDto = new UpdatePostDto(1)
            {
                Title = "new title"
            };
            await PostLogic.UpdateAsync(updatePostDto, 1);
            SearchPostParametersDto searchPostParametersDto = new SearchPostParametersDto(1);
            IEnumerable<Post> posts = await PostLogic.GetAsync(searchPostParametersDto);
            
            // Assert
            Assert.Equal("new title", posts.FirstOrDefault().Title);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task UpdateDescription()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            UpdatePostDto updatePostDto = new UpdatePostDto(1)
            {
                Description = "new description"
            };
            await PostLogic.UpdateAsync(updatePostDto, 1);
            SearchPostParametersDto searchPostParametersDto = new SearchPostParametersDto(1);
            IEnumerable<Post> posts = await PostLogic.GetAsync(searchPostParametersDto);
            
            // Assert
            Assert.Equal("new description", posts.FirstOrDefault().Description);
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
    
    [Fact]
    public async Task UpdateTags()
    {
        try
        {
            // Arrange
            await SetupDatabaseAsync();

            // Act
            IList<string> tagsList = new List<string>();
            tagsList.Add("Test tag1");
            tagsList.Add("Test tag2");
            tagsList.Add("Test tag3");

            UpdatePostDto updatePostDto = new UpdatePostDto(1)
            {
                Tags = tagsList
            };
            await PostLogic.UpdateAsync(updatePostDto, 1);
            SearchPostTagParameters searchPostTagParameters = new SearchPostTagParameters(null, 1);
            IEnumerable<Tag> tags = await TagDao.GetPostTagAsync(searchPostTagParameters);
            
            // Assert
            Assert.Equal(3, tags.Count());
        }
        finally
        {
            await TestLogic.SwitchToProductionDatabaseAsync();
        }
    }
}