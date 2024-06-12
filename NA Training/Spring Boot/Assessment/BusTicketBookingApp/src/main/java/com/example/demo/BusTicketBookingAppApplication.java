package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.entities")
@ComponentScan(basePackages="com.*")
@EnableJpaRepositories("com.repository")
public class BusTicketBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusTicketBookingAppApplication.class, args);
	}

}
