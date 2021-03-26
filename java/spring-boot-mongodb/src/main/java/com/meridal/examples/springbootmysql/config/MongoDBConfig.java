package com.meridal.examples.springbootmysql.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(MongoDBConfig.class);

    private static final String DATABASE = "mongodb.database";
    private static final String DATABASE_KEY = "${" + DATABASE + "}";
    private static final String URI = "mongodb.uri";
    private static final String URI_KEY = "${" + URI + "}";

    @Value(DATABASE_KEY)
    private String database;

    @Value(URI_KEY)
    private String uri;

    /**
     * Display imported values at startup.
     */
    @PostConstruct
    public void config() {
        LOG.info("{}={}", URI, this.uri);
        LOG.info("{}={}", DATABASE, this.database);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getDatabaseName() {
        return this.database;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MongoClient mongoClient() {
        return MongoClients.create(this.uri);
    }
}
