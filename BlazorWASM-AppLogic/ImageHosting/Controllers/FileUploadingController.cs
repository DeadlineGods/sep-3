using ImageHosting.Models;
using Microsoft.AspNetCore.Mvc;

namespace ImageHosting.Controllers;

[ApiController]
[Route("api/files")]
public class FileUploadingController : ControllerBase
{
    public readonly IWebHostEnvironment env;

    public FileUploadingController(IWebHostEnvironment env)
    {
        this.env = env;
    }

    [HttpPost]
    public string Post([FromForm] FileUpload objectFile)
    {
        try
        {
            if (objectFile.Files.Length > 0)
            {
                string path = env.WebRootPath + "\\uploads\\";
                if (!Directory.Exists(path))
                {
                    Directory.CreateDirectory(path);
                }

                using (FileStream fileStream = System.IO.File.Create(path + objectFile.Files.FileName))
                {
                    objectFile.Files.CopyTo(fileStream);
                    fileStream.Flush();
                    return "Uploaded.";
                }
            }
            else
            {
                return "Not Uploaded.";
            }
        }
        catch (Exception ex)
        {
            return ex.Message;
        }
    }
}
