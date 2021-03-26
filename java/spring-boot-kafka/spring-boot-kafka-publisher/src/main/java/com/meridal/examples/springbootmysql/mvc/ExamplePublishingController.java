package com.meridal.examples.springbootmysql.mvc;

import com.meridal.examples.springbootmysql.domain.Recording;
import com.meridal.examples.springbootmysql.service.ExamplePublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Example Publishing Controller.
 */
@RestController
@RequestMapping("api/publish/{id}")
public class ExamplePublishingController {
	
	@Autowired
	public ExamplePublishingService service;
	
	/**
	 * Publish a message.
	 * @param string
	 * @return Status
	 */
	@PostMapping
    public String publishMessage(@PathVariable final String id, @RequestBody final Recording recording) {
		this.service.publish(recording);
		return "success";
	}
}
