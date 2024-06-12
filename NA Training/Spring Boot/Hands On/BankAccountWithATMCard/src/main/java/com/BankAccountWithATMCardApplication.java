package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.bean")
@EnableJpaRepositories("com.repository")
public class BankAccountWithATMCardApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(BankAccountWithATMCardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Invoke the methods");

	}
}
