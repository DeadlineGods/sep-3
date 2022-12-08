using System.Text;
using Application.DAOsInterfaces;
using Application.GrpcClients;
using Application.Logic;
using Application.LogicInterfaces;
using Domain.Auth;
using HttpClients.Implementations;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.IdentityModel.Tokens;
using WebAPI.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddScoped<IAuthService, AuthService>();

builder.Services.AddScoped<IPostLogic, PostLogic>();
builder.Services.AddScoped<IPostDao, PostGrpcClient>();



builder.Services.AddScoped<IUserDao, UserGrpcClient>();
builder.Services.AddScoped<IUserLogic, UserLogic>();

builder.Services.AddScoped<ILocationDao, LocationGrpcClient>();
builder.Services.AddScoped<ILocationLogic, LocationLogic>();

builder.Services.AddScoped<ILikeDao, LikeGrpcClient>();
builder.Services.AddScoped<ILikeLogic, LikeLogic>();

builder.Services.AddScoped<ICommentDao, CommentGrpcClient>();
builder.Services.AddScoped<ICommentLogic, CommentLogic>();

builder.Services.AddScoped<ITagDao, TagGrpcClient>();
builder.Services.AddScoped<ITagLogic, TagLogic>();

builder.Services.AddScoped<IReportDao, ReportGrpcClient>();
builder.Services.AddScoped<IReportLogic, ReportLogic>();

builder.Services.AddScoped<IAdminDao, AdminGrpcClient>();
builder.Services.AddScoped<IAdminLogic, AdminLogic>();

builder.Services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme).AddJwtBearer(options =>
{
    options.RequireHttpsMetadata = false;
    options.SaveToken = true;
    options.TokenValidationParameters = new TokenValidationParameters()
    {
        ValidateIssuer = true,
        ValidateAudience = true,
        ValidAudience = builder.Configuration["Jwt:Audience"],
        ValidIssuer = builder.Configuration["Jwt:Issuer"],
        IssuerSigningKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(builder.Configuration["Jwt:Key"]))
    };
});

AuthorizationPolicies.AddPolicies(builder.Services);

var app = builder.Build();

app.UseCors(x => x
    .AllowAnyMethod()
    .AllowAnyHeader()
    .SetIsOriginAllowed(origin => true)
    .AllowCredentials());

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();
app.UseAuthentication();
app.UseAuthorization();

app.MapControllers();

app.Run();
