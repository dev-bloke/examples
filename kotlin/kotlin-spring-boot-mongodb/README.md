## Spring Boot MongoDB

This project illustrates how to combine [Spring Boot](http://projects.spring.io/spring-boot/) and
[MongoDB](https://www.mongodb.com) to create a simple, domain driven RESTful web service.

The project also uses [SpringFox](http://springfox.github.io/springfox/docs/current/) to provide a
[Swagger](http://swagger.io) JSON specification for the API which is rendered at the root of the
deployed service.

A Docker Compose file is also included that will spin up a suitable MongoDB instance for local
runtime testing. This is prepopulated with a small amount of sample data. If you have Docker and
Compose installed, simply cd to the project directory and use this command to start the MongoDB instance.

    docker-compose up -d

Note that this is not required to run the unit tests, which use an embedded MongoDB instance for any
database related testing.

To run this microservice use:

    ./gradlew kotlin-spring-boot-mongodb:bootRun

Each layer has a fairly comprehensive set of unit tests that can be run
in the usual way:

    ./gradlew kotlin-spring-boot-mongodb:test


