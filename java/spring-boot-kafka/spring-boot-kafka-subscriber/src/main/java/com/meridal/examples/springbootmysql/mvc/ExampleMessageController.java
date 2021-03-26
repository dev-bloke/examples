package com.meridal.examples.springbootmysql.mvc;

import java.util.List;

import com.meridal.examples.springbootmysql.service.ExampleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meridal.examples.springbootmysql.domain.Recording;

/**
 *Sandbox Message Controller.
 */
@RestController
public class ExampleMessageController {
	
	@Autowired
	private ExampleMessageService service;

	/**
	 * Get a message.
	 * @return The message sent with the supplied key
	 */
	@RequestMapping(value="api/message/{key}", method=RequestMethod.GET)
	public Recording getMessage(@PathVariable final String key) {
		return this.service.getMessage(key);
	}	
	
	/**
	 * Get all messages received thus far.
	 * @return A list of all messages
	 */
	@RequestMapping(value="api/messages", method=RequestMethod.GET)
	public List<Recording> getAllMessages() {
		return this.service.getAllMessages();
	}
}
