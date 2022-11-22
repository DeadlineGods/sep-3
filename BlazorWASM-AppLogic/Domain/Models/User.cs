using System;

namespace Domain.Models;

public class User
{
    public String userName{ get; set; }
    public String fullName{ get; set; }
    public String password{ get; set; }
    public String email{ get; set; }
    public String phoneNumber{ get; set; }

    public User(String userName, String fullname, String password, String email, String phoneNumber)
    {
        this.userName = userName;
        this.fullName = fullname;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }




}
