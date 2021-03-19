package com.meridal.examples.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class SwaggerConfiguration {

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.contact.email}")
    private String email;

    @Value("${swagger.contact.name}")
    private String name;

    @Value("${swagger.regex}")
    private String regex;

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.contact.url}")
    private String url;

    @Value("${swagger.version}")
    private String version;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(this.apiInfo())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.regex(this.regex))
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .contact(new Contact(this.name, this.url, this.email))
            .title(this.title)
            .description(this.description)
            .version(this.version)
            .build();
    }
}
