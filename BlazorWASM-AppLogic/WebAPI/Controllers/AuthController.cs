using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using Domain.DTOs;
using Domain.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;
using WebAPI.Services;
using JwtRegisteredClaimNames = Microsoft.IdentityModel.JsonWebTokens.JwtRegisteredClaimNames;

namespace WebAPI.Controllers;

[ApiController]
[Route("[controller]")]
public class AuthController : ControllerBase
{
    private readonly IConfiguration config;
    private readonly IAuthService authService;

    public AuthController(IConfiguration config, IAuthService authService)
    {
        this.config = config;
        this.authService = authService;
    }

    [HttpPost, Route("admin-login")]
    public async Task<ActionResult> AdminLoginAsync([FromBody] LoginDto dto)
    {
	    try
	    {
		    LoginDto loginDto = await authService.ValidateAdminAsync(dto.username, dto.password);
		    string token = GenerateJwt(loginDto);

		    return Ok(token);
	    }
	    catch (Exception e)
	    {
		    return BadRequest(e.Message);
	    }
    }

    [HttpPost, Route("login")]
    public async Task<ActionResult> LoginAsync([FromBody] LoginDto userLoginDto)
    {
        try
        {
            LoginDto dto = await authService.ValidateUserAsync(userLoginDto.username, userLoginDto.password);
            string token = GenerateJwt(dto);

            return Ok(token);
        }
        catch (Exception e)
        {
            return BadRequest(e.Message);
        }
    }

    [HttpPost, Route("register")]
    public async Task<ActionResult> RegisterAsync([FromBody]UserCreationDto userDto)
    {
        try
        {
            User user = await authService.RegisterUserAsync(userDto);

            return Ok(user);
        }
        catch (Exception e)
        {
	        return BadRequest(e.Message);
        }
    }

    private List<Claim> GenerateClaims(LoginDto dto)
    {
        var claims = new[]
        {
            new Claim(JwtRegisteredClaimNames.Sub, config["Jwt:Subject"]),
            new Claim(JwtRegisteredClaimNames.Jti, Guid.NewGuid().ToString()),
            new Claim(JwtRegisteredClaimNames.Iat, DateTime.UtcNow.ToString()),
            new Claim(ClaimTypes.Name, dto.username)
        };
        return claims.ToList();
    }

    private string GenerateJwt(LoginDto dto)
    {
        List<Claim> claims = GenerateClaims(dto);

        SymmetricSecurityKey key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(config["Jwt:Key"]));
        SigningCredentials signIn = new SigningCredentials(key, SecurityAlgorithms.HmacSha512);

        JwtHeader header = new JwtHeader(signIn);

        JwtPayload payload = new JwtPayload(
            config["Jwt:Issuer"],
            config["Jwt:Audience"],
            claims,
            null,
            DateTime.UtcNow.AddMinutes(60));

        JwtSecurityToken token = new JwtSecurityToken(header, payload);

        string serializedToken = new JwtSecurityTokenHandler().WriteToken(token);
        return serializedToken;
    }


}
