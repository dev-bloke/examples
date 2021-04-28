package com.meridal.examples.kotlinspringbootamqp.config

import org.slf4j.LoggerFactory
import org.springframework.amqp.core.Queue
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
class AMQPConfig {

    private val LOG = LoggerFactory.getLogger(AMQPConfig::class.java)

    @Value("\${messaging.queue}")
    private val queueName: String? = null

    @PostConstruct
    fun setup() {
        LOG.info("messaging.queue=" + queueName)
    }

    @Bean
    fun queue(): Queue? {
        return Queue(queueName, false)
    }
}