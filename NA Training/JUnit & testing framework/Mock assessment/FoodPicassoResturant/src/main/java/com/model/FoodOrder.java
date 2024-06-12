package com.model;

public class FoodOrder {
	private int orderId;
	private String customerName;
	private String foodName;
	private String foodType;//Can be Veg and NonVeg
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
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
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
	
	public FoodOrder(int orderId, String customerName, String foodName, String foodType, int quantity,
			String deliveryType, double cost) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.foodName = foodName;
		this.foodType = foodType;
		this.quantity = quantity;
		this.deliveryType = deliveryType;
		this.cost = cost;
	}
	
	

}
