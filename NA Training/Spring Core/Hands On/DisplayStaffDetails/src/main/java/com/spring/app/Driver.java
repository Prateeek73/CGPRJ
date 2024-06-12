package com.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	
	public static Department loadStaffDetails(){
	    ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
	    return appContext.getBean(Department.class, "departmentObj");
	}

	public static void main(String[] args) {
		Department department = loadStaffDetails();
		department.displayStaffDetails();
	}
}
