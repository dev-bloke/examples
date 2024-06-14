package com.meridal.examples.springboot.solid.mvc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Solid", description = "The Solid API")
@RestController
@RequestMapping("/api")
public class SolidController {

	@Operation(summary = "Say Hello")
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello world!";
	}
}
