package com.apps.bedms.dtos;

import java.util.Objects;

public class Address implements Comparable<Address>{

	private Long id;
	private String city;
	private String state;
	private Long pincode;

	public Address() {
		super();
	}
	
	public Address(String city, String state, Long pincode) {
		super();
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}

	@Override
	public int compareTo(Address o) {
		if(this.getId().equals(o.getId()))
			return 1;
		return 0;
	}
}
