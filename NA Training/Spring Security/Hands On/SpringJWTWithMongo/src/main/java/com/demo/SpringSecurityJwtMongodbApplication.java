package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({"com.*"})
@EnableMongoRepositories({"com.*"})
public class SpringSecurityJwtMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtMongodbApplication.class, args);
	}

}
