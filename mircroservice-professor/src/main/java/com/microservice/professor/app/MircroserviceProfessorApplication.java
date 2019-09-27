package com.microservice.professor.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MircroserviceProfessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircroserviceProfessorApplication.class, args);
	}

}
