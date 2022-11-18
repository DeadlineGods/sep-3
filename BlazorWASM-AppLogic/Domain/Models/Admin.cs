using System;

namespace Domain.Models;

public class Admin
{
    public String username { get; set; }
    public String password { get; set; }


    public Admin(string username, string password)
    {
        this.username = username;
        this.password = password;
    }
}