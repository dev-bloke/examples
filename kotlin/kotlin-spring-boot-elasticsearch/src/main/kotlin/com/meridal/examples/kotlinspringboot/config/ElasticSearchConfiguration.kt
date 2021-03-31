package com.meridal.examples.kotlinspringboot.config

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@Configuration
@EnableElasticsearchRepositories(basePackages = ["com.meridal.examples.springbootelasticsearch.repository"])
class ElasticSearchConfiguration(): AbstractElasticsearchConfiguration() {

    @Value("\${elasticsearch.endpoint}")
    val endpoint: String? = null

    @Bean
    override fun elasticsearchClient(): RestHighLevelClient {
        val config = ClientConfiguration.builder().connectedTo(endpoint).build()
        return RestClients.create(config).rest()
    }
}