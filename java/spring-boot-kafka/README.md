Spring Boot Kafka
=================

This project contains three components that combine to illustrate Kafka publishing and subscription using Spring Boot.

Prerequisites
=============

* Java 11+
* Maven 3.6.1+
* Kafka 2.1+

Building
========

From IDE (Eclipse, STS, Intellij)
---------------------------------

Simply import the contents of this directory as a Maven project.

From The Command Line
---------------------

    mvn clean package

Running the Application
=======================

There are three components:

* Spring Boot Kafka Publisher is a microservice that consumes REST requests and publishes them to a Kafka topic.
* Spring Boot Kafka Subscriber is a microservice that consumes messages from that Kafka topic and holds them in an in-memory store. These
  messages can be viewed using the REST interface provided within the same component.
* Kafka Domain provides the common data model used for the messages.

The components are configured to connect to Kafka running locally on port 9092 with Zookeeper running on port 2181.

To install Kafka and Zookeeper via Homebrew:

    brew install kafka
	
To get Kafka responding on localhost I had to change a setting in /usr/local/etc/kafka/server.properties, but YMMV:

	listeners=PLAINTEXT://localhost:9092

To create the topic used by the application, use kafka_topics thus:

	kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic examples

Run or debug the components with the ```Application``` main class at the root of the Java package hierarchy

Alternately, you may use the following Maven targets to run the application from either the command line or 
your IDE:

    mvn spring-boot:run

Testing
=======

* To publish a message, visit [http://localhost:8080/](http://localhost:8080/) to use the REST API.
* To view messages that have arrived via subscription, visit [http://localhost:8081/](http://localhost:8081/) to use the REST API.

