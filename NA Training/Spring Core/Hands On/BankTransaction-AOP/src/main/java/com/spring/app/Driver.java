package com.spring.app;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Driver {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Bank obj=(Bank)ctx.getBean("bankObj");
		System.out.println(obj.withDraw(101,500));
		
		
		
	}

}
