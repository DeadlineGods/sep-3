using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;
using Grpc.Core;

namespace Application.Logic;

public class TagLogic : ITagLogic
{
    private readonly ITagDao tagDao;

    public TagLogic(ITagDao tagDao)
    {
        this.tagDao = tagDao;
    }

    public async Task<string[]> CreateAsync(PostTagCreationDto dto)
    {
        return await tagDao.CreateAsync(dto);
    }

    public async Task<IEnumerable<TagPost>> GetPostTagAsync(SearchPostTagParameters searchParameters)
    {
        return await tagDao.GetPostTagAsync(searchParameters);
    }

    public async Task<IEnumerable<Tag>> GetTagListAsync(SearchTagListParameters searchParameters)
    {
        return await tagDao.GetTagListAsync(searchParameters);
    }

    public async Task DeleteTask(long postId)
    {
        await tagDao.DeleteAsync(postId);
    }
}
