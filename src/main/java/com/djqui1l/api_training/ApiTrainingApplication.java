package com.djqui1l.api_training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.djqui1l.api_training.repository")
public class ApiTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTrainingApplication.class, args);
	}
}
