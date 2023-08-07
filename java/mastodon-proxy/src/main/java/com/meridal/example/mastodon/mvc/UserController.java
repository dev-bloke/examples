package com.meridal.example.mastodon.mvc;

import com.meridal.example.mastodon.domain.UserProfile;
import com.meridal.example.mastodon.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Users", description = "The Twitter User Profile API")
@RestController
@RequestMapping("/api/user")
public class UserController {

	private final UserService service;

	public UserController(@Autowired final UserService service) {
		this.service = service;
	}

	@Operation(summary = "Get a user profile by user name")
	@GetMapping("/{username}")
	public UserProfile getUserProfile(@PathVariable final String username) {
		return this.service.getUserProfile(username);
	}

	@Operation(summary = "Get a user profile in CSV format by user name")
	@GetMapping("/{username}/csv")
	public String getUserProfileAsCSV(@PathVariable final String username) {
		return this.service.getUserProfileAsCSV(username);
	}
}
