## Spring Boot MySQL

This project illustrates how to combine [Spring Boot](http://projects.spring.io/spring-boot/) and 
[MySQL](http://http://dev.mysql.com/) to create a simple, domain driven RESTful web service.

The project also uses [SpringFox](http://springfox.github.io/springfox/docs/current/) to provide a 
[Swagger](http://swagger.io) JSON specification for the API which is rendered at the root of the 
deployed service.

A Docker Compose file is also included that will spin up a suitable MySQL 8.0 instance for local 
runtime testing. This is prepopulated with a small amount of sample data. If you have Docker and
Compose installed, simply cd to the project directory and use this command to start the MySQL instance.

    docker-compose up -d

Note that this is not required to run the unit tests, which use an internal H2 database for any 
database related testing.