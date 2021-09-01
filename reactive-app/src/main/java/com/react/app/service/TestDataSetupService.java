package com.react.app.service;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

@Service
public class TestDataSetupService implements CommandLineRunner {

	@Value("classpath:h2/init.sql")
	private Resource initSql;

	@Autowired
	private R2dbcEntityTemplate r2dbcEntityTemplate;

	@Override
	public void run(String... args) throws Exception {
		String sql = StreamUtils.copyToString(initSql.getInputStream(), StandardCharsets.UTF_8);
		System.out.println("Executing SQL :"+ sql);
		r2dbcEntityTemplate
			.getDatabaseClient()
			.sql(sql)
			.then()
			.subscribe();
	}

}
