package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

//Provide necessary Annotation
@Entity
public class BookTicket {
	//Provide necessary Annotation
	@Id
	private int ticketId;
	//Provide necessary Annotation
	
	@ManyToOne
	@JoinColumn(name="bus_id")
	private Bus busObj;
	private String customerName;
	private int noOfSeats;
	private double busFare;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public Bus getBusObj() {
		return busObj;
	}
	public void setBusObj(Bus busObj) {
		this.busObj = busObj;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public double getBusFare() {
		return busFare;
	}
	public void setBusFare(double busFare) {
		this.busFare = busFare;
	}
	public BookTicket(int ticketId, Bus busObj, String customerName, int noOfSeats, double busFare) {
		super();
		this.ticketId = ticketId;
		this.busObj = busObj;
		this.customerName = customerName;
		this.noOfSeats = noOfSeats;
		this.busFare = busFare;
	}
	public BookTicket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
