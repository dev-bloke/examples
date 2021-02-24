package com.meridal.examples.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

import com.meridal.examples.domain.Recording;

/**
 * Example Kafka Repository.
 */
@Repository
public class ExampleKafkaRepository {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExampleKafkaRepository.class);
	
	private final String topic;
	
	@Autowired
	private KafkaTemplate<String, Recording> kafkaTemplate;
	
	/**
	 * Constructor.
	 * @param topic Topic to publish to.
	 */
	@Autowired
	public ExampleKafkaRepository(@Value("${messaging.topic}") final String topic) {
		this.topic = topic;
		LOG.info("Example Kafka topic = {}", this.topic);	
	}
	
	/**
	 * Publish a message.
	 * @param item Sandbox item
	 */
	public void publish(final Recording recording) {
	    kafkaTemplate.send(this.topic, recording.getId(), recording);
	    LOG.info("Message sent to topic {}: {}", this.topic, recording);
	}
}
