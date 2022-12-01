using Application.DAOsInterfaces;
using Domain.DTOs;
using Domain.Models;
using Grpc.Net.Client;
using GrpcClient;
using Tags = Domain.Models.Tag;

namespace Application.GrpcClients;

public class TagGrpcClient : ITagDao
{
    private readonly IPostDao postDao;

    public TagGrpcClient(IPostDao postDao)
    {
        this.postDao = postDao;
    }

    
    public async Task<IEnumerable<Tag>> GetAsync(SearchTagParameters searchParameters)
    {
        using var channel = GrpcChannel.ForAddress("http://localhost:6565");
        /*
        var client = new TagService.TagServiceClient(channel);
        
        var reply = await client.GetTagAsync(
            new RequestGetPostTag
            {
                PostId = parameters.PostId ?? 0,
                TagContains = parameters.TagContains ?? ""
            });

        IList<Tag> tags = new List<Tag>();
        foreach (var replyTag in reply.Tags)
        {
            tags.Add(await ConstructTagAsync(replyTag));
        }
        */
        IList<Tag> tags = new List<Tag>();
        return await Task.FromResult(tags);
    }
    
    /*
    private async Task<Tag> ConstructTagAsync(PostTagData reply)
    {
        SearchPostParameters dto = new SearchPostParameters(reply.PostId, null, null);
        IEnumerable<Post> posts = await postDao.GetAsync(dto);

        return new Tag( reply.TagContains, posts.FirstOrDefault().Id);
    }*/
}
