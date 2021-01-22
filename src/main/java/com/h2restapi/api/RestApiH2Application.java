package com.h2restapi.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestApiH2Application {

	public static void main(String[] args) {
		SpringApplication.run(RestApiH2Application.class, args);
	}

}
