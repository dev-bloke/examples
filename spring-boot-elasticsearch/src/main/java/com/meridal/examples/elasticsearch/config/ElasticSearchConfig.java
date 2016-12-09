package com.meridal.examples.elasticsearch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * ElasticSearch 2.x Configuration.
 * @author Martin Ingram (a-maingram)
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.meridal.examples.elasticsearch.repository")
public class ElasticSearchConfig {
}
