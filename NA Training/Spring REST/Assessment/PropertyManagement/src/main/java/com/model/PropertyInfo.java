package com.model;

public class PropertyInfo {
	
	private int propertyId;
	private String propertyType;
	private String dimension;
	private String location;
	private double cost;
	private String status;
	
	public PropertyInfo() {
		
	}
	
	public PropertyInfo(int propertyId, String propertyType, String dimension, String location, double cost,
			String status) {
		
		this.propertyId = propertyId;
		this.propertyType = propertyType;
		this.dimension = dimension;
		this.location = location;
		this.cost = cost;
		this.status = status;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
