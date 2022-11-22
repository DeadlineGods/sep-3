namespace Domain.DTOs;

public class UserCreationDto
{
    public String userName{ get; set; }
    private String fullName{ get; set; }
    public String password{ get; set; }
    private String email{ get; set; }
    private String phoneNumber{ get; set; }

    public UserCreationDto(String userName, String fullname, String password, String email, String phoneNumber)
    {
        this.userName = userName;
        this.fullName = fullname;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}