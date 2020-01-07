package com.example.algamoney.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class AlgamoneyApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AlgamoneyApiApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure( SpringApplicationBuilder builder) {
		return builder.sources(AlgamoneyApiApplication.class);
	}
}
