## Spring Boot Docker

This project illustrates how to assemble and deploy a [Spring Boot](http://projects.spring.io/spring-boot/) 
and [Freemarker](http://freemarker.org) based web app in a [Docker](https://docker.com/) container.

See the [Spring Boot With Docker guide](https://spring.io/guides/gs/spring-boot-docker/) for detailed 
steps. For the impatient

    mvn clean package docker:build
    docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 -t meridal/spring-boot-docker