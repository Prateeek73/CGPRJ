package com.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
	
	public static Order loadBookDetails() {
	    ApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		return appContext.getBean(Order.class);
	}

	public static void main(String[] args) {
	    Order order = loadBookDetails();
	    order.displayOrderDetails();
	}
}
