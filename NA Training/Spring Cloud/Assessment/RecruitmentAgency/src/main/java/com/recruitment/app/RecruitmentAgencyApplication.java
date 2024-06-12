package com.recruitment.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.*")
public class RecruitmentAgencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentAgencyApplication.class, args);
	}

}
