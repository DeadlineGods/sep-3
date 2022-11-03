namespace Domain.Models;

public class User
{
    private String userName{ get; set; }
    private String fullName{ get; set; }
    private String password{ get; set; }
    private String email{ get; set; }
    private String phoneNumber{ get; set; }

    public User(String userName, String fullname, String password, String email, String phoneNumber)
    {
        this.userName = userName;
        this.fullName = fullname;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    

    
}