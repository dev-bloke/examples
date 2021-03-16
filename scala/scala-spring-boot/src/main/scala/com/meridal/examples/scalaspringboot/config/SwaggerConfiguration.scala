package com.meridal.examples.scalaspringboot.config

import springfox.documentation.swagger2.annotations.EnableSwagger2
import org.springframework.context.annotation.Configuration
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.spi.DocumentationType
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.service.Contact

@EnableSwagger2
@Configuration
class SwaggerConfiguration {
  
  @Value("${swagger.description}")
  var description: String = ""

  @Value("${swagger.contact.email}")
  var email: String = ""

  @Value("${swagger.contact.name}")
  var name: String = ""

  @Value("${swagger.regex}")
  var regex: String = ""

  @Value("${swagger.title}")
  var title: String = ""

  @Value("${swagger.contact.url}")
  val url: String = ""

  @Value("${swagger.version}")
  var version: String = ""

  @Bean
  def api(): Docket  = new Docket(DocumentationType.SWAGGER_2)
    .apiInfo(apiInfo())
    .select()
    .apis(RequestHandlerSelectors.any())
    .paths(PathSelectors.regex(regex))
    .build()

  private def apiInfo(): ApiInfo = new ApiInfoBuilder()
    .contact(new Contact(name, url, email))
    .title(title)
    .description(description)
    .version(version)
    .build()
}
