AWS CloudFormation
==================

Various templates for use with the AWS "infrastructure as code" facility. Please note that
although all of these are runnable under the AWS Free Tier, Amazon will charge you for 
the resources whilst they are running if you fall outside that scheme. 

As with all CloudFormation stacks, when you delete a stack you should also remember to empty 
and delete the related S3 buckets that contain the stack configuration, as these are NOT 
deleted automatically.

The templates here are:

vpc.yaml
--------

Creates a Virtual Private Cloud (VPC) with basic subnets and routing.

ec2-ubuntu.yaml
---------------

Creates an EC2 instance running Ubuntu Server 20.04 LTS, with public access via SSH and
a previously generated key file. The server has an Elastic (static) IP address allocated
to it.

ec2-nginx.yaml
--------------

Creates an EC2 instance running Ubuntu Server 20.04 LTS, with public access via SSH and
a previously generated key file. The latest version of Nginx is preinstalled and configured
to serve public facing content over HTTP, using an Elastic (static) IP address and DNS name.

ec2-nginx-php-fpm-mysql.yaml
----------------------------

Creates a classic LNMP stack that can be used for applications like WordPress. This stack
consists of an EC2 instance running Ubuntu Server 20.04 LTS, the latest versions of Nginx,
PHP FPM and the MySQL client, plus a small (5GB SSD) MySQL 8.0 RDS instance.

The RDS instance is only accessible from the EC2 instance. The EC2 instance can be accessed
via SSH using a specified key file, and also serves public facing content via HTTP, using
an Elastic (static) IP address and DNS name.
