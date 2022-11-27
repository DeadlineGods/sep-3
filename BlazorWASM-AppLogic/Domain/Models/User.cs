using System;
using System.Text.Json.Serialization;

namespace Domain.Models;

public class User
{
    public long Id { get; set; }
    public String UserName{ get; set; }
    private String FullName{ get; set; }
    public String Password{ get; set; }
    private String Email{ get; set; }
    private String PhoneNumber{ get; set; }

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