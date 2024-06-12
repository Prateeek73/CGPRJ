package com.model;

public class Leave {
	
	private int empId;
	private String leave_from;
	private String leave_to;
	private String reason;
	private String leave_status;
	private String leave_type;
	public String getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getLeave_from() {
		return leave_from;
	}
	public void setLeave_from(String leave_from) {
		this.leave_from = leave_from;
	}
	public String getLeave_to() {
		return leave_to;
	}
	public void setLeave_to(String leave_to) {
		this.leave_to = leave_to;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getLeave_status() {
		return leave_status;
	}
	public void setLeave_status(String leave_status) {
		this.leave_status = leave_status;
	}
	
	
	public Leave(int empId, String leave_from, String leave_to, String reason, String leave_type) {
		super();
		this.empId = empId;
		this.leave_from = leave_from;
		this.leave_to = leave_to;
		this.reason = reason;
		this.leave_type = leave_type;
	}
	public Leave(int empId, String leave_from, String leave_to, String reason, String leave_status, String leave_type) {
		super();
		this.empId = empId;
		this.leave_from = leave_from;
		this.leave_to = leave_to;
		this.reason = reason;
		this.leave_status = leave_status;
		this.leave_type = leave_type;
	}
	public Leave() {
		super();
	}
	
	
	
	
	

}
