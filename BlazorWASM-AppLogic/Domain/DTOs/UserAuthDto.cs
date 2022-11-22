namespace Domain.DTOs;

public class UserAuthDto
{
    public String userName{ get; set; }
    private String firstName{ get; set; }
    private String lastName{ get; set; }

    public String password{ get; set; }
    private String email{ get; set; }
    private String phoneNumber{ get; set; }

    public UserAuthDto(String userName, String firstName, String lastName,String password, String email, String phoneNumber)
    {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}