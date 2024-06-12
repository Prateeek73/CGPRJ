package com.model;

public class OnlineOrder {
	private int orderId;
	private String customerName;
	private String itemName;
	private String itemType; //Can be Electronics, Mobiles, Essentials and Fashion
	private int quantity;
	private  String deliveryType;  //Can be FastDelivery and NormalDelivery
	private double cost;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public OnlineOrder(int orderId, String customerName, String itemName, String itemType, int quantity,
			String deliveryType, double cost) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.itemName = itemName;
		this.itemType = itemType;
		this.quantity = quantity;
		this.deliveryType = deliveryType;
		this.cost = cost;
	}
	
	

}
