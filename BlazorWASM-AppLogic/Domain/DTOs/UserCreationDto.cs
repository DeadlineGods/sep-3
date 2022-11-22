namespace Domain.DTOs;

public class UserCreationDto
{
    public String userName{ get; set; }
    public String fullName{ get; set; }
    public String password{ get; set; }
    public String email{ get; set; }
    public String phoneNumber{ get; set; }

    public UserCreationDto(String userName, String fullname, String password, String email, String phoneNumber)
    {
        this.userName = userName;
        this.fullName = fullname;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}