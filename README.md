# Photoguard 📸🛡️🌍

## InstalationGuide ⚙️
[![installation guide](http://img.youtube.com/vi/VUrcQIYMvJk/1.jpg)](https://youtu.be/VUrcQIYMvJk)

Please don't forget to change `pw` and `user` in the `DBConnection` file in Data server to your local credentials!
<img width="411" alt="Screenshot 2022-12-15 at 9 44 16 AM" src="https://user-images.githubusercontent.com/62465860/207813525-8c9bab39-8705-49bf-999c-6db4792b915e.png">

# About the project 💻
  <b>The idea for the project came from the desire to contribute to solving the 17 Global Goals presented by the UN in 2015. One of them, the eleventh goal called "Sustainable cities and communities", forces the inhabitants of both cities and villages to reflect. In order for the world to prepare for the growing population of urbanized areas, it is necessary to look at and solve the problems that exist here now. This is how the idea for the Photoguard web application was born, the aim of which is to raise awareness about the problems in cities by providing a space for conversation, available to everyone. The application allows you to see problems occurring around the world and locally, by adding the so-called posts, describing the problem graphically and in words. It is also supposed to allow for open discussion and interaction between users, through the ability to comment on posts, show support, through the ability to "like" a post, as well as the ability to report a post if it is not related to the topic of the application or if it violates its rules.

  Photoguard is a distributed system with 3-tier architecture including: Client presentation tier, logic servers tier and data server tier with connection to the database. First tier is written in HTML, CSS, JS and C# using Blazor framework and it is connected to second tier by RESTful API sending and receiving JSON files. Server to host images in the second tier is written in C# using Web API. App logic server is written in C#, but also communicates with third tier using gRPC framework which uses Protocol Buffers. Third tier data server is written in Java and communicates with PostgreSQL database with JDBC. Additionally, system uses Google Maps API.
  
  For the best workflow, SCRUM combined with UP was chosen to follow and managed in Jira (Atlassian) tool. OneDrive was used to store relevant files. All UML diagrams were created in Astah Professional. Whole process of the development was stored and secured with GIT version control system and GitHub managing tool.

  As a result, all 19 requirements were successfully implemented creating an application with expected features. Tiers communicates by technologies that allow to replace or add new client, server or database in different languages, what makes the system reliable, manageable, adaptable and scalable. App is covered with 42 test units, which cover valuable business logic. The product fulfils the expectations.	<b>
