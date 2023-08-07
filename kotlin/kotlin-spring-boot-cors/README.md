# Kotlin Spring Boot CORS

This is a small Spring Boot REST microservice with CORS Filtering written in Kotlin, complete
with a Swagger based web testing API.

To keep things simple, this example uses an internal H2 database that
requires no further configuration.

To run this microservice use:

    ./gradlew kotlin-spring-boot-cors:bootRun

Each layer has a fairly comprehensive set of unit tests that can be run
in the usual way:

    ./gradlew kotlin-spring-boot-cors:test


