package com.spring.app;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		
		Company comObj=(Company)ctx.getBean(Company.class);
		Employee empObj=(Employee)ctx.getBean(Employee.class);
		empObj.setEmpId(100);
		empObj.setEmpName("John");
		empObj.setEmailId("john@gmail.com");
		comObj.registerEmployee(empObj);
		
		Employee empObj1=(Employee)ctx.getBean(Employee.class);
		empObj1.setEmpId(101);
		empObj1.setEmpName("Peter");
		empObj1.setEmailId("peter@gmail.com");
		comObj.registerEmployee(empObj1);
	
	}

}
