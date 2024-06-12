package com.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//Provide necessary Annotation
@Entity
public class Bus {
	//Provide necessary Annotation
	@Id
	private int busId;
	private String busNo;
	private String busType;
	private String source;
	private String destination;
	//Provide necessary Annotation
	
	@OneToMany(mappedBy="busObj", cascade = CascadeType.ALL)
	private List<BookTicket> tickets;
	
	
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bus(int busId, String busNo, String busType, String source, String destination, List<BookTicket> tickets) {
		super();
		this.busId = busId;
		this.busNo = busNo;
		this.busType = busType;
		this.source = source;
		this.destination = destination;
		this.tickets = tickets;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public List<BookTicket> getTickets() {
		return tickets;
	}
	public void setTickets(List<BookTicket> tickets) {
		this.tickets = tickets;
	}
	
}