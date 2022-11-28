using Shared;

namespace HttpClients.ClientInterfaces;

public interface IImageUploadService
{
    Task<string> UploadAsync(ImageFile imageFile);
}