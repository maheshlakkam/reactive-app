package com.react.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.react.app.model.SampleResponse;
import com.react.app.model.User;
import com.react.app.repository.UserRepository;

import reactor.core.publisher.Flux;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Flux<SampleResponse> findUsers() {
		return userRepository.findAll()
				.map(e->e.getId())
				.map(SampleResponse::new);
	}
}
