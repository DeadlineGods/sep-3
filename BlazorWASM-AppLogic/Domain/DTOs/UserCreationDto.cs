
namespace Domain.DTOs;

public class UserCreationDto
{
	public String username { get; set; }
	public String password { get; set; }
	public String firstName { get; set; }
	public String lastName { get; set; }
	public String email { get; set; }
	public String phoneNumber { get; set; }

	public UserCreationDto(string username, string password, string firstName, string lastName, string email, string phoneNumber)
	{
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
}
