using ImageHosting.Models;
using Microsoft.AspNetCore.Mvc;

namespace ImageHosting.Controllers;

[ApiController]
[Route("api/files")]
public class FileUploadingController : ControllerBase
{
    private readonly IWebHostEnvironment _env;

    public FileUploadingController(IWebHostEnvironment env)
    {
        _env = env;
    }

    [HttpPost]
    public string Post([FromForm] FileUpload objectFile)
    {
        try
        {
            if (objectFile.Files.Length > 0)
            {
                string path = _env.WebRootPath + "\\StaticFile\\";
                if (!Directory.Exists(path))
                {
                    Directory.CreateDirectory(path);
                }

                string fileName = Path.GetFileNameWithoutExtension(objectFile.Files.FileName);
                string fileExtension = Path.GetExtension(objectFile.Files.FileName);
                while (CheckIfNameExists(path, fileName))
                {
                    fileName += "_new";
                }

                using (FileStream fileStream = System.IO.File.Create(path + fileName + fileExtension))
                {
                    objectFile.Files.CopyTo(fileStream);
                    fileStream.Flush();
                    return "https://localhost:7174/staticfile/" + fileName + fileExtension;
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

    private bool CheckIfNameExists(string filePath, string targetFileName)
    {
        string[] fileEntries = Directory.GetFiles(filePath);
        foreach (string fileNameFull in fileEntries)
        {
           string fileName =  Path.GetFileNameWithoutExtension(fileNameFull);
           if (fileName.Equals(targetFileName))
           {
               return true;
           }
        }

        return false;
    }
}
