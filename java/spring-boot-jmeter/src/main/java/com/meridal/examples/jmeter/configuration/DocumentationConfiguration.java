package com.meridal.examples.jmeter.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger documentation configuration.
 * @author Martin Ingram
 */
@Configuration
public class DocumentationConfiguration {

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.contact.email}")
    private String email;

    @Value("${swagger.contact.name}")
    private String name;

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.contact.url}")
    private String url;

    @Value("${swagger.version}")
    private String version;

    /**
     * Generate custom OpenAPI attributes.
     * @return Custom OpenAPI attributes
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title(this.title)
                .version(this.version)
                .description(this.description)
                .contact(this.contactDetails())
            );
    }

    /**
     * Generate contact details.
     * @return Contact details
     */
    private final Contact contactDetails() {
        return new Contact()
            .name(this.name)
            .email(this.email)
            .url(this.url);
    }
}

