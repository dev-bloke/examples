## Spring Boot ElasticSearch

This project illustrates how to combine [Spring Boot](http://projects.spring.io/spring-boot/), 
[Spring Data ElasticSearch](https://spring.io/projects/spring-data-elasticsearch) and 
[ElasticSearch](https://www.elastic.co) to create a simple, domain driven REST microservice.

The project also uses [SpringFox](http://springfox.github.io/springfox/docs/current/) to provide a 
[Swagger](http://swagger.io) JSON specification for the API which is rendered at the root of the 
deployed service.

A Docker Compose file is also included that will spin up a suitable ElasticSearch instance for local
runtime testing. This is prepopulated with a small amount of sample data. If you have Docker and
Compose installed, simply cd to the project directory and use this command to start the ElasticSearch instance.

    docker-compose up -d

Note that this is not required to run the unit tests. At the time of writing, ElasticSearch do not provide
a simple mechanism for running an embedded, in-memory version of the database, so there are no integration
tests for the repository code. 