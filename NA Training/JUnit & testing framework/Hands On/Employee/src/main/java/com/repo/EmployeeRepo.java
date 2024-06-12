package com.repo;

import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

public class EmployeeRepo {
	
	private static List<Employee> empList = new ArrayList<Employee>();
	
	public int addEmployeeToList(Employee e) {
		empList.add(e);
		return empList.size();
	}
	
	public void deleteEmployeeFromList(Employee e) {
		boolean b = empList.remove(e);
	}
	
	public Employee getEmployeeByEmployeeId(int empId) {
		for (Employee e :empList) 
			if(e.getEmployeeId()==empId)
				return e;
		return null;
	}
	
	public List<Employee> getEmployee() {
		return empList;
	}
}
