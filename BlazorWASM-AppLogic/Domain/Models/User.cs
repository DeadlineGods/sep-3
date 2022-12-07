using System;
using System.Text.Json.Serialization;

namespace Domain.Models;

public class User
{
    public long Id { get; set; }
    public string UserName{ get; set; }
    public string FullName{ get; set; }
    public string Password{ get; set; }
    public string Email{ get; set; }
    public string PhoneNumber{ get; set; }
    public long LocationId { get; set; }

    [JsonConstructor]
    public User() {}

    public User(long id, string userName, string fullname, string password, string email, string phoneNumber, long locationId)
    {
        Id = id;
        UserName = userName;
        FullName = fullname;
        Password = password;
        Email = email;
        PhoneNumber = phoneNumber;
        LocationId = locationId;
    }




}
