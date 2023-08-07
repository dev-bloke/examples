package com.meridal.examples.kotlinspringboot.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CrossOriginRequestConfiguration: WebMvcConfigurer {

    @Value("\${cors.enabled}")
    val enabled: Boolean? = null

    @Value("\${cors.mapping}")
    val mapping: String? = null

    @Value("\${cors.origins}")
    val origins: String? = null

    @Value("{#'\${cors.methods}'.split(',')}")
    val methods: String?[] = arrayOf<String>()

    @Value("\${cors.credentials}")
    val credentials: Boolean? = null

    @Value("\${cors.maxAge}")
    val maxAge: Long? = null

    fun addCorsMapping(registry: CorsRegistry) {
        if (enabled) {
            registry.addMapping(mapping.orEmpty())
                .allowedOrigins(origins.orEmpty())
                .allowedMethods(methods)
                .allowCredentials(credentials)
                .maxAge(maxAge.);
        }
    }
}