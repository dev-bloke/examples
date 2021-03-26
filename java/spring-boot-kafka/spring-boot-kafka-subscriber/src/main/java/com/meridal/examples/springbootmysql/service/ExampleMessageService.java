package com.meridal.examples.springbootmysql.service;

import java.util.List;

import com.meridal.examples.springbootmysql.repository.ExampleMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meridal.examples.springbootmysql.domain.Recording;

/**
 * Example Message Service.
 */
@Service
public class ExampleMessageService {

	@Autowired
	private ExampleMessageRepository repository;

	/**
	 * Get a message.
	 * @param id Message ID
	 * @return Sandbox item
	 */
	public Recording getMessage(String id) {
		return this.repository.getOrDefault(id, new Recording());
	}
	
	/**
	 * Save a message.
	 * @param id ID
	 * @param item Item
	 */
	public void saveMessage(String id, Recording item) {
		this.repository.put(id, item);
	}
	
	/**
	 * Get all messages.
	 * @return A list of all messages.
	 */
	public List<Recording> getAllMessages() {
		return this.repository.getAllItems();
	}
}
