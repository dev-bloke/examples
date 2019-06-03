Spring Boot Kafka Subscriber
============================

This is a Spring Boot based application that subscribes to a Kafka topic.

Prerequisites
=============

* Java 11
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

The application is configured to connect to Kafka running locally on port 9092 with Zookeeper running on port 2181.

To install Kafka and Zookeeper via Homebrew:

    brew install kafka
	
To get Kafka responding on localhost I had to change a setting in /usr/local/etc/kafka/server.properties, but YMMV:

	listeners=PLAINTEXT://localhost:9092

To create the topic used by the application, use kafka_topics thus:

	kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic examples

Run or debug the app with the ```Application``` main class at the root of the Java package hierarchy

Alternately, you may use the following Maven targets to run the application from either the command line or 
your IDE:

    mvn spring-boot:run

Testing
=======

* Visit [http://localhost:8081/](http://localhost:8081/) to view the REST API.
