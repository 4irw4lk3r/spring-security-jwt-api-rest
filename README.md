# spring-security-jwt-api-rest
Exemplo de uma API REST utilizando Spring Security + JWT

## Steps to Setup the Spring Boot Back end app (polling-app-server)

1. **Clone the application**

	```bash
	git clone https://github.com/4irw4lk3r/spring-security-jwt-api-rest.git
	cd spring-security-jwt-api-rest
	```

2. **Create MySQL database**

	```bash
	create database locadora_db
	```

3. **Change MySQL username and password as per your MySQL installation**

	+ open `src/main/resources/application.yaml` file.

	+ change `datasource:username:` and `datasource:password:` properties as per your mysql installation
  
4. **Default Roles**
	
	The spring boot app uses role based authorization powered by spring security. To add the default roles in the database, I have added the following sql queries in `src/main/resources/data.sql` file.

	```sql
	INSERT IGNORE INTO roles(name) VALUES('ROLE_USER');
	INSERT IGNORE INTO roles(name) VALUES('ROLE_ADMIN');
	```

	Any new user who signs up to the app is assigned the `ROLE_USER` by default.
  
5. **Default Movies**
	
	To add the default movies in the database, I have added the following sql queries in `src/main/resources/data.sql` file.

```sql
INSERT INTO `locadora_db`.`movies`(`director_name`,`number_of_copies_available`,`number_of_copies_max`,`title`) VALUES('George Lucas',5,5,'Star Wars: Episode IV'); 
INSERT INTO `locadora_db`.`movies`(`director_name`,`number_of_copies_available`,`number_of_copies_max`,`title`) VALUES('Irvin Kershner',3,3,'The Empire Strikes Back: Episode V');
INSERT INTO `locadora_db`.`movies`(`director_name`,`number_of_copies_available`,`number_of_copies_max`,`title`) VALUES('Richard Marquand',7,7,'Return of the Jedi : Episode VI');  
```
  
6. **REST APIs**

In this application, we will expose REST APIs for vehicle resources.

URI|request|response|description
---|---|---|---
/api/user/all|GET|200 {id:'id', name:'name', username:'username', email:'email', password:'password'}| Get all users
/api/auth/signup|POST {name:'name', username:'username', email:'email', password:'password'} | 200 | Create a new user
/api/auth/signin|POST {usernameOrEmail:'usernameOrEmail', password:'password'}|200, Authorization token | Login 
/api/movie/findAllAvailable|GET|401, Unauthorized| Find all movies available
/api/movie/findByTitle/{title}|GET|401, Unauthorized| Find a movie by id 
/api/movie/rent/{id}|POST|401, Unauthorized| Rent a movie
/api/movie/return/{id}|POST|401, Unauthorized| Return a movie 
