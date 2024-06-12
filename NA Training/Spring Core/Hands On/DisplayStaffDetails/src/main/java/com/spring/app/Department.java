package com.spring.app;

import java.util.List;

public class Department {
	
	private int departmentId;
	private List<Staff> staffs;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public List<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}
	
	public Department(int departmentId, List<Staff> staffs){
	    this.departmentId = departmentId;
	    this.staffs = staffs;
	}
	
	public void displayStaffDetails() {
	    System.out.println("Staff Details:");
	    for(Staff staff : staffs){
	        System.out.println("Staff Id:" + staff.getStaffId());
	        System.out.println("Staff Name:" + staff.getStaffName());
	        System.out.println("Contact Number:" + staff.getContactNo());
	        System.out.println("Department Name:" + staff.getDepartmentName());
	        System.out.println("Department Id:" + this.departmentId);
	    }
	}
}
