package com.meridal.examples.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.meridal.examples.repository")
public class DynamoDBConfig {

    private static final Logger LOG = LoggerFactory.getLogger(DynamoDBConfig.class);

    private static final String ENDPOINT = "dynamodb.endpoint";
    private static final String ENDPOINT_KEY = "${" + ENDPOINT + "}";
    private static final String ACCESS = "dynamodb.key.access";
    private static final String ACCESS_KEY = "${" + ACCESS + "}";
    private static final String SECRET = "dynamodb.key.secret";
    private static final String SECRET_KEY = "${" + SECRET + "}";

    @Value(ENDPOINT_KEY)
    private String endpoint;

    @Value(ACCESS_KEY)
    private String accessKey;

    @Value(SECRET_KEY)
    private String secretKey;

    @PostConstruct
    public void config() {
        LOG.info("{}={}", ENDPOINT, this.endpoint);
        LOG.info("{}={}", ACCESS, this.accessKey);
        LOG.info("{}={}", SECRET, this.secretKey);
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider()).build();
    }

    public AWSCredentialsProvider amazonAWSCredentialsProvider() {
        return new AWSStaticCredentialsProvider(amazonAWSCredentials());
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(this.accessKey, this.secretKey);
    }
}