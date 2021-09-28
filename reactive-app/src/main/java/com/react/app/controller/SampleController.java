package com.react.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.react.app.model.SampleRequest;
import com.react.app.model.SampleResponse;
import com.react.app.service.SampleService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("react")
public class SampleController {

	@Autowired
	SampleService sampleService;

	@GetMapping("/sample/data/{id}")
	public Mono<SampleResponse> getData(@PathVariable int id) {
		return sampleService.getData(id);
	}

	@GetMapping("/sample/details")
	public Flux<SampleResponse> getDetails() {
		return sampleService.getDetails();
	}

	@GetMapping(value = "/sample/details/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<SampleResponse> getDetailsStream() {
		return sampleService.getDetails();
	}

	@PostMapping(value = "/sample/data")
	public Mono<SampleResponse> store(Mono<SampleRequest> request) {
		return sampleService.store(request);
	}
}
