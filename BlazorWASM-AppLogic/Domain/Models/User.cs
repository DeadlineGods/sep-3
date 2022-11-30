using System;
using System.Text.Json.Serialization;

namespace Domain.Models;

public class User
{
    public long Id { get; set; }
    public String UserName{ get; set; }
    public String FullName{ get; set; }
    public String Password{ get; set; }
    public String Email{ get; set; }
    public String PhoneNumber{ get; set; }

    [JsonConstructor]
    public User() {}


    public User(long id, String userName, String fullname, String password, String email, String phoneNumber)
    {
        Id = id;
        UserName = userName;
        FullName = fullname;
        Password = password;
        Email = email;
        PhoneNumber = phoneNumber;
    }




}
