package com.meridal.examples.kotlinspringboot.config

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableDynamoDBRepositories(basePackages = ["com.meridal.examples.kotlinspringboot.repository"])
class DynamoDBConfiguration {

    @Value("\${dynamodb.endpoint}")
    val endpoint: String = ""

    @Value("\${dynamodb.region}")
    val region: String = ""

    @Value("\${dynamodb.key.access}")
    val accessKey: String = ""

    @Value("\${dynamodb.key.secret}")
    val secretKey: String = ""

    @Bean
    fun amazonDynamoDB() = AmazonDynamoDBClientBuilder.standard()
        .withCredentials(credentials())
        .withEndpointConfiguration(endpoint())
        .build()

    @Bean
    fun credentials() = AWSStaticCredentialsProvider(BasicAWSCredentials(accessKey, secretKey))

    @Bean
    fun endpoint() = AwsClientBuilder.EndpointConfiguration(endpoint, region)
}