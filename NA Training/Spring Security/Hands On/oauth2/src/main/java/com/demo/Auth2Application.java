package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@ComponentScan({"com.*"})
public class Auth2Application extends WebSecurityConfigurerAdapter {

	
	
	public static void main(String[] args) {
		
		SpringApplication.run(Auth2Application.class, args);
	}

}
