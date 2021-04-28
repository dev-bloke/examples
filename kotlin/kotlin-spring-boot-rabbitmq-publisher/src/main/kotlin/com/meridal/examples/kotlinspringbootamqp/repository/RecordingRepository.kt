package com.meridal.examples.kotlinspringbootamqp.repository

import com.meridal.examples.domain.Recording
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository

@Repository
class RecordingRepository @Autowired constructor(private val template: RabbitTemplate) {

    @Value("\${messaging.queue}")
    val queueName: String? = null

    fun publish(recording: Recording) {
        template.convertAndSend(queueName!!, recording)
    }
}