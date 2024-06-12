package com.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
	    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Shipment Details1");
	    Shipment shipment1 = getShipment(sc, context);
	    Shipment shipment2 = getShipment(sc, context);
	    
	    System.out.println();
	    System.out.println("Delivery status of shipment ID: " + shipment1.getShipmentId() + " is " + shipment1.getDeliveryStatus());
	    System.out.println("Delivery status of shipment ID: " + shipment2.getShipmentId() + " is " + shipment2.getDeliveryStatus());
        sc.close();
	}	 
    private static Shipment getShipment(Scanner sc, ApplicationContext context){
        
        System.out.print("Enter the Item Name ");
        String itemName = sc.nextLine();
        
        System.out.print("Enter the Item Price ");
        double price = sc.nextDouble();
        sc.nextLine();
        
        System.out.print("Enter the ShipmentId ");
        String shipmentId = sc.nextLine();
        
        System.out.print("Enter the Delivery Status ");
        String deliveryStatus = sc.nextLine();
        
        Shipment shipment = context.getBean(Shipment.class);
        shipment.getItem().setItemName(itemName);
        shipment.getItem().setPrice(price);
        shipment.setShipmentId(shipmentId);
        shipment.setDeliveryStatus(deliveryStatus);
        
        return shipment;
    }
	
}
