package com.react.app.service;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.react.app.model.SampleRequest;
import com.react.app.model.SampleResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SampleService {

	public Mono<SampleResponse> getData(int id) {
		return Mono.fromSupplier(() -> id).map(SampleResponse::new);
	}

	public Flux<SampleResponse> getDetails() {
		return Flux.range(0, 10)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(e -> System.out.println("current element is:" + e))
				.map(SampleResponse::new);
	}
	
	public Mono<SampleResponse> store(Mono<SampleRequest> request) {
		return request
				.map(e->e.getId())
				.map(SampleResponse::new);
	}
}

