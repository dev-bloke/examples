package com.meridal.examples.springbootmysql.config;

import com.meridal.examples.springbootmysql.service.ExampleMessageService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.meridal.examples.springbootmysql.domain.Recording;

/**
 * Sandbox Kafka Listener Configuration.
 */
@Configuration
public class ExampleKafkaListenerConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExampleKafkaListenerConfig.class);
	
	@Autowired
	private ExampleMessageService service;
	
	/**
	 * Listen for messages.
	 * @param record Message record
	 */
	@KafkaListener(topics = "${messaging.listener.topic}") 
	public void listen(ConsumerRecord<String, Recording> record) {
		LOG.info("Received message: key={}, value={}", record.key(), record.value());
		this.service.saveMessage(record.key(), record.value());
	}
}
