using ImageHosting.Models;
using Microsoft.AspNetCore.Mvc;
using Shared;

namespace ImageHosting.Controllers;

[ApiController]
[Route("")]
public class ImageUploadingController : ControllerBase
{
    private readonly IWebHostEnvironment _env;

    public ImageUploadingController(IWebHostEnvironment env)
    {
        _env = env;
    }

    [HttpPost]
    public async Task<ActionResult<string>> PostAsync([FromBody] ImageFile file)
    {
        var buf = Convert.FromBase64String(file.base64data);
        string randomName = Path.GetRandomFileName();
        string fileName = randomName + "_" + file.fileName;
        string fileFolder = "StaticFile/";
        await System.IO.File.WriteAllBytesAsync(_env.ContentRootPath + "wwwroot/" + fileFolder + fileName, buf);

        return Ok("https://localhost:7174/" + fileFolder + fileName);
    }
}
