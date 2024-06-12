package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Leave;

@Service
public class LeaveService {

	private static List<Leave> leaveList=new ArrayList<Leave>();

	public LeaveService() {
		leaveList.add(new Leave(101, "3-Feb-2023", "5-Feb-2023", "not well","approved", "SL"));
		leaveList.add(new Leave(102, "3-Mar-2023", "5-Mar-2023", "","notapproved", "CL"));
		leaveList.add(new Leave(103, "14-Apr-2023", "14-Apr-2023", "tami new year","approved", "RH"));
		leaveList.add(new Leave(104, "15-Feb-2023", "15-Feb-2023", "not well","approved", "SL"));
		leaveList.add(new Leave(105, "3-Feb-2023", "5-Feb-2023", "", "notapproved","CL"));
		leaveList.add(new Leave(106, "3-Feb-2023", "5-Mar-2023", "met with an accident","approved", "ML"));
	}
	public static List<Leave> getLeaveList() {
		return leaveList;
	}

	public static void setLeaveList(List<Leave> leaveList) {
		
		LeaveService.leaveList = leaveList;
	}
	
	public Leave applyLeave(Leave l) {
		leaveList.add(l);
		return l;
	}
	
	public Leave viewAllBasedOnLeaveStatus(String status) {
		for(Leave leave:leaveList) {
			if(leave.getLeave_status().equalsIgnoreCase(status))
			{
				return leave;
			}
		}
		return null;
	}
	
	public Leave applyLeave(int empId, String leave_from, String leave_to, String reason, String leave_type)
	{
		Leave l=new Leave(empId,leave_from,leave_to,reason,leave_type);
		leaveList.add(l);
		return l;
	}
	public List<Leave> viewAllLeaveRequest(){
		
		return leaveList;
	}
	
	public Leave approveLeaveRequest(int empId){
		for(Leave leave:leaveList) {
			if(leave.getEmpId()==empId)
			{
				if(leave.getReason()!="")
				{
				leave.setLeave_status("approved");
				return leave;
				}
				else
				{
					leave.setLeave_status("notapproved");	
					return leave;
				}
			}
		}
		return null;
	}
}
