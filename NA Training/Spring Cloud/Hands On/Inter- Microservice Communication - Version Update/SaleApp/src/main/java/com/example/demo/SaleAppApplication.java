package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.*")
@ComponentScan(basePackages = "com.*")
public class SaleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaleAppApplication.class, args);
	}

}
