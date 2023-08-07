package com.meridal.examples.recordcollection.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

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

	@Bean
	public OpenAPI customOpenAPI() {
		final Contact contact = new Contact()
			.name(this.name)
			.email(this.email)
			.url(this.url);
		return new OpenAPI()
			.info(new Info()
				.title(this.title)
				.version(this.version)
				.description(this.description)
				.contact(contact)
			);
	}
}
