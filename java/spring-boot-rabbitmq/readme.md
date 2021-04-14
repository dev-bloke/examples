# Spring Boot RabbitMQ

This project illustrates how to combine [Spring Boot](http://projects.spring.io/spring-boot/) and 
[RabbitMQ](https://www.rabbitmq.com) to create a simple, domain driven messaging solution.

The project also uses [SpringFox](http://springfox.github.io/springfox/docs/current/) to provide a 
[Swagger](http://swagger.io) JSON specification for the API which is rendered at the root of the 
deployed service.

A Docker Compose file is also included that will spin up a suitable RabbitMQ instance for local 
runtime testing.

    docker-compose up -d

There are three subprojects:

## Spring Boot RabbitMQ Publisher

This is a simple REST service that accepts POSTs containing domain objects and publishes them on
a RabbitMQ queue. This service runs on [port 8080](http://localhost:8080).

## Spring Boot RabbitMQ Subscriber

This is a simple microservice that subscribes to the queue and listens for any incoming messages. 
Each domain object is saved in a list in memory. The service also has a simple REST based GET 
endpoint that returns all objects received in the current session. This service runs on [port 8081](http://localhost:8081).

## RabbitMQ Domain

This provides the common domain model used by the other two subprojects.