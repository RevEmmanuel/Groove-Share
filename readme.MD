# Groove-Share API
This ia a Java Spring boot server application to handle creating, sharing and transfer of Playlists across streaming platforms.

### Features
* `Signup`
* `Login`

### Technologies used:
* `Java`
* `Springboot`
* `PostgreSQL`
* `Swagger Docs`
* `JWT`
* `Spotify for Developers`

### Prerequisites:
* `Java 8 or higher`
* `Maven`
* `PostgreSQL Database`
* `Port 9090 open and free`

[![My Skills](https://skillicons.dev/icons?i=java,spring,mysql,postgresql,postman)](https://skillicons.dev)

# Getting Started
### Clone the Repository
```
git clone https://github.com/RevEmmanuel/Groove-Share.git
```

### Configure the database
Create a PostgreSQL database and update the database configuration in the `application-{profile}.properties` file. The default active profile is "dev"
```properties
db.host=
db.name=
db.username=
db.password=
Jwt_Secret_Key=
```

### Build and Run the Application
Navigate to the project directory and build the application using Maven:
```
cd url-shortener
mvn clean install
```
Run the application using Maven:
```
mvn spring-boot:run
```
The application will start running on `http://localhost:9090`.

## Documentation
The API documentation is available through Swagger UI. You can access it using the following link:
* [Swagger Docs](http://localhost:9090/swagger-ui.html)
* [Postman Documentation](https://bit.ly/revemmanuel-groove-share)

## Developer & Engineer
Adeola Adekunle
* [GitHub (RevEmmanuel)](https://github.com/RevEmmanuel)
* [Twitter (@Adeola_Ade1)](https://twitter.com/Adeola_Ade1)
* [Instagram (@deolaaxo)](https://www.instagram.com/deolaaxo/)
* [LinkedIn (Adeola Adekunle)](https://www.linkedin.com/in/adeola-adekunle-emmanuel/)
* [Email(Adeola Adekunle)](mailto:adeolaae1@gmail.com)

## License
This project is licensed under the [MIT license](https://opensource.org/license/mit/)
