package com.spring.app;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	
	public static GoldRateInfo loadGoldRateDetails() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		return appContext.getBean(GoldRateInfo.class, "rateInfoObj");
	}
	
    public static void main(String[] args){
	    Scanner sc =new Scanner(System.in);
	    GoldRateInfo goldRateInfo = loadGoldRateDetails();
	    
	    System.out.println("Enter the carat: ");
	    int carat = sc.nextInt();
	    
	    System.out.println("Enter Total Grams: ");
	    double grams = sc.nextDouble();
	    
	    System.out.println("Total Gold Rate is Rs: " + goldRateInfo.calculateGoldRate(carat, grams));
    }
}