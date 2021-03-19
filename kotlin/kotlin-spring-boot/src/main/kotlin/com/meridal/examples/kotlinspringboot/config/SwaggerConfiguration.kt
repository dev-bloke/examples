package com.meridal.examples.kotlinspringboot.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
class SwaggerConfiguration {

    @Value("\${swagger.description}")
    val description: String? = null

    @Value("\${swagger.contact.email}")
    val email: String? = null

    @Value("\${swagger.contact.name}")
    val name: String? = null

    @Value("\${swagger.regex}")
    val regex: String? = null

    @Value("\${swagger.title}")
    val title: String? = null

    @Value("\${swagger.contact.url}")
    val url: String? = null

    @Value("\${swagger.version}")
    val version: String? = null

    @Bean
    open fun api(): Docket  = Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.regex(regex))
        .build()

    private fun apiInfo(): ApiInfo = ApiInfoBuilder()
        .contact(Contact(name, url, email))
        .title(title)
        .description(description)
        .version(version)
        .build()
}