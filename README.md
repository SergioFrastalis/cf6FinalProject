

This is the final project for the bootcamp: "Coding Factory 6" , KEDIVIM, AUEB.

Short Description

It is a REST API, with Java-Spring boot (gradle, lombok) on the backend, and Thymeleaf, HTML, CSS 
( and a little bit of bootstrap) on the frontend.
The database used is MySQL.
Testing conducted with Postman and Swagger.

It is a mock version of a nutrition app. It consists of a register page (/register), where one can insert their name,
last name, email and password, followed by a login page (/login).
The registry data are saved in the aforementioned MySQl database. The password is encrypted.
All new registrations are by default set to "user".
However, the administrator of the database can change the rights of a user from "user" to "admin".
"User" when logging in, is redirected to the main page (/foods), which is a simple nutrient table generator 
for a few types of food.
"Admin" when logging in, is redirected to a page (/users) which shows a table of all registered users.



Built details: 
Spring Security
Spring Data JPA
Spring Web
Thymeleaf
Encryption by BcryptPasswordEncoder
Hibernate used for Object Relational Mapping
Schema synchronization management is managed by application.properties

Deployment:
JDK 17+
MySQL Server (database name is cf6finalprojectlogindb)
Application.properties configurations.

Architecture Details:
Controllers: They handle http requests and route them to the appropriate services.
Services: They connect controllers and repositories.
Repositories: Interacts with the database.
Entities: Defines all data, users and foods. 
Security: Manages rights to visit pages and encryption.
Templates: The front end (the html pages)
A complementary .json file "foods" has been added to resources/documentation, for the convenience of the user/examiner.

Author, Sergio F., based on the notes and video lectures of Coding Factory 6

