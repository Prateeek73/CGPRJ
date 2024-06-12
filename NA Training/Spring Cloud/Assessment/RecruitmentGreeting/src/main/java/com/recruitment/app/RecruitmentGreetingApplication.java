package com.recruitment.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.recruitment.controller"})
public class RecruitmentGreetingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentGreetingApplication.class, args);
	}

}
