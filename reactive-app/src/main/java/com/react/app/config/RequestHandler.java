package com.react.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.react.app.model.SampleResponse;
import com.react.app.service.SampleService;

import reactor.core.publisher.Mono;

@Service
public class RequestHandler {

	@Autowired
	private SampleService sampleService;

	public Mono<ServerResponse> getDataHandler(ServerRequest serverRequest) {
		int id = Integer.parseInt(serverRequest.pathVariable("id"));
		Mono<SampleResponse> sampleResponse = sampleService.getData(id);
		return ServerResponse.ok().body(sampleResponse, SampleResponse.class);
	}
}
