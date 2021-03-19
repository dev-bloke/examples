package com.meridal.examples.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class SwaggerConfig {

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.contact.email}")
    private String email;	  

    @Value("${swagger.license.type}")
    private String license;

    @Value("${swagger.licence.url}")
    private String licenseUrl;

    @Value("${swagger.contact.name}")
    private String name;
    
    @Value("${swagger.regex}")
    private String regex;

    @Value("${swagger.tos.url}")
    private String termsOfServiceUrl;

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.contact.url}")
    private String url;

    @Value("${swagger.version}")
    private String version;

    @Bean
    public Docket docket(){
	return new Docket(DocumentationType.SWAGGER_2)
	    .select()
	    .apis(RequestHandlerSelectors.any())
	    .paths(PathSelectors.regex(this.regex))
	    .build()
	    .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
	return new ApiInfoBuilder()
	    .contact(new Contact(this.name, this.url, this.email))
	    .description(this.description)
	    .license(this.license)
	    .licenseUrl(this.licenseUrl)
	    .title(this.title)
	    .termsOfServiceUrl(this.termsOfServiceUrl)
	    .version(this.version)
	    .build();
    }	
}
