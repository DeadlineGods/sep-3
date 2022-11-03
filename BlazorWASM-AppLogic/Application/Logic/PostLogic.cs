using Application.DAOsInterfaces;
using Application.LogicInterfaces;

namespace Application.Logic;

public class PostLogic : IPostLogic
{
    private readonly IPostDao postDao;

    public PostLogic(IPostDao postDao)
    {
        this.postDao = postDao;
    }
    
    public async Task<Post> CreateAsync(PostCreationDto postCreationDto)
    {
        ValidatePost(postCreationDto);

        Post post = new Post();
        
        return await postDao.CreateAsync(post);
    }

    private void ValidatePost(PostCreationDto postCreationDto)
    {
        throw new NotImplementedException();
    }
}