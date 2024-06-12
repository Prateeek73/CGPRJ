package com.spring.app;

import java.util.ArrayList;

public class Company {

	ArrayList<Employee> al = new ArrayList<Employee>();

	public ArrayList<Employee> getAl() {
		return al;
	}

	public void setAl(ArrayList<Employee> al) {
		this.al = al;
	}

	public boolean registerEmployee(Employee e) {
		return al.add(e);
	}
}