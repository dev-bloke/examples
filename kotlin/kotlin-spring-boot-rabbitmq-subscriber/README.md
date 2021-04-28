# Kotlin Spring Boot RabbitMQ Subscriber

This is a simple Spring Boot microservice written in Kotlin that subscribes to a RabbitMQ queue and listens for any incoming messages.
Each domain object is saved in a list in memory. The service also has a simple REST based GET
endpoint that returns all objects received in the current session. This service runs on [port 8081](http://localhost:8081).

A companion microservice that subscribes to the same channel can be found in kotlin-spring-boot-rabbitmq-publisher.

A Docker Compose file is also included that will spin up a suitable RabbitMQ instance for local runtime testing.

    docker-compose up -d

The same file can also be found in the subscriber project.

To run this microservice use:

    ./gradlew kotlin-spring-boot-rabbitmq-subscriber:bootRun

Please note that it was a _deliberate_ decision to not include unit tests in this project. The components and methods
are simply one line call cascades down to the Spring AQMP Template, so any test would merely use a mock to ensure that
call had been made, which seems fairly pointless.

