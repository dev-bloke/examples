# Kotlin Spring Boot RabbitMQ Publisher

This is a small Spring Boot REST microservice written in Kotlin that publishes data to RabbitMQ, complete
with a Swagger based web testing API. A companion microservice that subscribes to the same channel can be
found in kotlin-spring-boot-rabbitmq-subscriber.

A Docker Compose file is also included that will spin up a suitable RabbitMQ instance for local runtime testing.

    docker-compose up -d

The same file can also be found in the subscriber project.

To run this microservice use:

    ./gradlew kotlin-spring-boot-rabbitmq-publisher:bootRun

Please note that it was a _deliberate_ decision to not include unit tests in this project. The components and methods
are simply one line call cascades down to the Spring AQMP Template, so any test would merely use a mock to ensure that
call had been made, which seems fairly pointless.

