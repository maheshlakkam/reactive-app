package com.react.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

	@Autowired
	RequestHandler requestHandler;

	@Bean
	public RouterFunction<ServerResponse> serverRouterFunction() {
		return RouterFunctions
				.route()
				.GET("router/sample/data/{id}", requestHandler::getDataHandler)
				.build();
	}
}
