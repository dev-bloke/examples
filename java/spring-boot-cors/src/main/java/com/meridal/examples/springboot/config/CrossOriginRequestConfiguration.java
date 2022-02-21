package com.meridal.examples.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@Configuration
public class CrossOriginRequestConfiguration implements WebMvcConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(CrossOriginRequestConfiguration.class);

    private static final String ARRAY_PREFIX = "#{'${";
    private static final String ARRAY_SUFFIX = "}'.split(',')}";

    private static final String ENABLED = "cors.enabled";
    private static final String ENABLED_KEY = "${" + ENABLED + "}";
    private static final String MAPPING = "cors.mapping";
    private static final String MAPPING_KEY = "${" + MAPPING + "}";
    private static final String ORIGINS = "cors.origins";
    private static final String ORIGINS_KEY = ARRAY_PREFIX + ORIGINS + ARRAY_SUFFIX;
    private static final String METHODS = "cors.methods";
    private static final String METHODS_KEY = ARRAY_PREFIX + METHODS + ARRAY_SUFFIX;
    private static final String CREDENTIALS = "cors.credentials";
    private static final String CREDENTIALS_KEY = "${" + CREDENTIALS + "}";
    private static final String MAX_AGE = "cors.maxAge";
    private static final String MAX_AGE_KEY = "${" + MAX_AGE + "}";

    @Value(ENABLED_KEY)
    private String enabled;

    @Value(MAPPING_KEY)
    private String mapping;

    @Value(ORIGINS_KEY)
    private String[] origins;

    @Value(METHODS_KEY)
    private String[] methods;

    @Value(CREDENTIALS_KEY)
    private boolean credentials;

    @Value(MAX_AGE_KEY)
    private long maxAge;

    /**
     * Log the config settings.
     */
    @PostConstruct
    public void config() {
        LOG.info("{}={}", ENABLED, this.enabled);
        LOG.info("{}={}", MAPPING, this.mapping);
        LOG.info("{}={}", ORIGINS, this.origins);
        LOG.info("{}={}", METHODS, this.methods);
        LOG.info("{}={}", CREDENTIALS, this.credentials);
        LOG.info("{}={}", MAX_AGE, this.maxAge);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (this.enabled.equals("true")) {
            LOG.info("Enabling CORS for {}", this.mapping);
            registry.addMapping(this.mapping)
                    .allowedOrigins(this.origins)
                    .allowedMethods(this.methods)
                    .allowCredentials(this.credentials)
                    .maxAge(this.maxAge);
        } else {
            LOG.info("CORS is disabled for this instance.");
        }
    }
}
