using Application.DAOsInterfaces;
using Domain.DTOs;
using Domain.Models;
using Grpc.Net.Client;
using GrpcClient;

namespace Application.GrpcClients;

public class TagGrpcClient : ITagDao
{
    private readonly IPostDao postDao;

    public TagGrpcClient(IPostDao postDao)
    {
        this.postDao = postDao;
    }

    
    public async Task<IEnumerable<TagPost>> GetPostTagAsync(SearchPostTagParameters searchParameters)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        
        var client = new TagService.TagServiceClient(channel);

        var reply = await client.GetPostTagAsync(
            new RequestGetPostTag
            {
                PostId = searchParameters.postId ?? 0,
                TagContains = searchParameters.tagContains ?? ""
            });

        IList<TagPost> tags = new List<TagPost>();
        foreach (var replyTag in reply.Tags)
        {
            tags.Add(await ConstructPostTagAsync(replyTag));
        }
        
        return await Task.FromResult(tags);
    }

    public async Task<IEnumerable<Tag>> GetTagListAsync(SearchTagListParameters searchParameters)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        
        var client = new TagService.TagServiceClient(channel);

        var reply = await client.GetTagListAsync(
            new RequestGetTagList
            {
                TagContains = searchParameters.TagContains ?? ""
            });

        IList<Tag> tags = new List<Tag>();
        foreach (var replyTag in reply.Tags)
        {
            tags.Add(await ConstructTagListAsync(replyTag));
        }
        
        return await Task.FromResult(tags);
    }


    private async Task<TagPost> ConstructPostTagAsync(PostTagData reply)
    {
        SearchPostParameters dto = new SearchPostParameters(reply.PostId, null, null);
        IEnumerable<Post> posts = await postDao.GetAsync(dto);

        return new TagPost( reply.TagContains, posts.FirstOrDefault().Id);
    }
    private async Task<Tag> ConstructTagListAsync(TagListData reply)
    {
        return new Tag( reply.TagContains);
    }
}
