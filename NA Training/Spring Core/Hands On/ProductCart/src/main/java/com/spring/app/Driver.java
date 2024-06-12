package com.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String args[]) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        Cart cart = appContext.getBean(Cart.class);
		double totalPrice = cart.getProductList()
		                .stream()
		                .mapToDouble(Product::getPrice)
		                .sum();
		System.out.println("Total Price Rs: " + totalPrice);
	}
}
