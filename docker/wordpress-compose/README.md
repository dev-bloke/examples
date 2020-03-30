Wordpress with Nginx, PHP-FPM and MySQL
=======================================

These scripts set up a local Docker environment with separate containers for Nginx, PHP-FPM and MySQL.
Presently this provides a runtime for Wordpress 5.2.1.


Prerequisites
=============

* Docker 2.0+
* Docker Compose 1.23+

Building
========

To build and start the environment, simply use

	docker-compose up -d
	

Running the Application
=======================

To complete the setup of your Wordpress instance, visit [http://localhost/wp-admin/install.php](http://localhost/wp-admin/install.php).

To stop the services in the environment, with all data persisted for the next run

	docker-compose stop
	
Then to restart the services

    docker-compose start
    
To stop and completely remove all containers, networks and volumes

	docker-compose down
	
NB: this will remove all your data (blog posts etc.) as well.

Testing and Diagnostics
=======================

To connect to a command prompt within a particular container

	docker exec -it <container-name> bash

As is standard, most if not all the logs will be found in /var/log. You can also see these using

	docker logs <container-name>

Developer Notes
===============

Three containers are created and started. These can be viewed using

	docker-compose ps

* The Nginx runtime, wordpress-nginx
* The MySQL (MariaDB) runtime, wordpress-mysql-server
* The PHP FPM runtime, wordpress-php-fpm

The Wordpress files are shared across Nginx and PHP-FPM using a volume

* wordpress-volume

This can be seen using 

	docker volume inspect wordpress-volume
	
The services run in a common network

* wordpress-bridge-network

This can be seen using

	docker volume inspect wordpress-bridge-network



