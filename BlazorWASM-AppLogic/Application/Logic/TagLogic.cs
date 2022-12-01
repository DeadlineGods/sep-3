using Application.DAOsInterfaces;
using Application.LogicInterfaces;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class TagLogic : ITagLogic
{
    private readonly ITagDao tagDao;

    public TagLogic(ITagDao tagDao)
    {
        this.tagDao = tagDao;
    }

    public async Task<IEnumerable<Tag>> GetAsync(SearchTagParameters searchParameters)
    {
        return await tagDao.GetAsync(searchParameters);
    }
}
