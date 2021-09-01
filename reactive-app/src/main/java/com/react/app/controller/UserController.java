package com.react.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.react.app.model.SampleResponse;
import com.react.app.service.UserService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("react")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public Flux<SampleResponse> loadUsers() {
		return userService.findUsers();
	}

}
