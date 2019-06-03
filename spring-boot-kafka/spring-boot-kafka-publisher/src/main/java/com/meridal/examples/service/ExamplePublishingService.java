package com.meridal.examples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meridal.examples.domain.Recording;
import com.meridal.examples.repository.ExampleKafkaRepository;

/**
 * Example publishing service.
 */
@Service
public class ExamplePublishingService {

	@Autowired
	private ExampleKafkaRepository repository;
	
	/**
	 * Publish a message.
	 * @param message Message
	 */
	public void publish(final Recording recording) {
		this.repository.publish(recording);
	}
}
