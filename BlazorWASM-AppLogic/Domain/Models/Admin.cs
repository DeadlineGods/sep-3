using System;

namespace Domain.Models;

public class Admin
{
    public string username { get; set; }
    public string password { get; set; }
    public string email { get; set; }



    public Admin(string username, string password, string email)
    {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
