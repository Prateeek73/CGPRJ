package com.service;

import java.util.List;
import com.model.Employee;
import com.repo.EmployeeRepo;

public class EmployeeService {
	
	EmployeeRepo emp = new EmployeeRepo();
	
	public int addEmployee(Employee e) {
	    if(emp.addEmployeeToList(e)>0)
		    return emp.addEmployeeToList(e);
		else
		    return 0;
	}
	
	public void deleteEmployee(Employee e) {

		emp.deleteEmployeeFromList(e);
	}
	
	public Employee fetchEmployeeById(int empId) {
		Employee e = emp.getEmployeeByEmployeeId(empId);
		if(e!=null)
			return e;
		else
			throw new NullPointerException();
	}
	
	public List<Employee> fetchEmployee(){
		List<Employee> empList = emp.getEmployee();
		if(empList.size()==0)
			throw new RuntimeException("Empty List");
		else
			return empList;
	}
}
