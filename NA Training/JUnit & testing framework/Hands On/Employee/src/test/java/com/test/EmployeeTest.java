package com.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import com.model.Employee;
import com.service.EmployeeService;
import com.repo.EmployeeRepo;

@ExtendWith(MockitoExtension.class)
public class EmployeeTest {
	
	@Mock
	EmployeeRepo repo;
	
	@InjectMocks
	EmployeeService service;
	
	@Test
	public void test1AddEmployee() {
	    Employee employee = new Employee(1, "John Snitch", "john@dead.com", 5000);
	    
	    when(repo.addEmployeeToList(employee))
	            .thenReturn(1);
	            
	    assertEquals(1, service.addEmployee(employee));
	}
	
	@Test
	public void test2DeleteEmployee() {
	    Employee employee = new Employee(1, "John Snitch", "john@dead.com", 5000);
	    
	    service.deleteEmployee(employee);
	
	    verify(repo, times(1))
	        .deleteEmployeeFromList(employee);
	}
	
	@Test
	public void test3FetchEmployeeByEmployeeId() {
	    Employee employee = new Employee(1, "John Snitch", "john@dead.com", 5000);
	    
	    when(repo.getEmployeeByEmployeeId(1))
	        .thenReturn(employee);
	    
	    Employee fetchedEmployee = service.fetchEmployeeById(1);
	    
	    verify(repo, times(1))
	        .getEmployeeByEmployeeId(1);
	        
	    assertEquals(employee, fetchedEmployee);
	}
	
	@Test
	public void test4FetchEmployeeByEmployeeIdWhenNull() {
		try{
		    service.fetchEmployeeById(1);
		    fail("Expected NullPointerException not thrown");
		} catch(NullPointerException ex){
		    
		}
	}
	
	@Test
	public void test5FetchEmployee() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "John Snitch", "john@dead.com", 5000));
		employees.add(new Employee(1, "John Fisk", "john@bed.com", 7000.0));
		
		when(repo.getEmployee())
		    .thenReturn(employees);
		
		List<Employee> fetchedEmployees = service.fetchEmployee();
		
		verify(repo, times(1))
		    .getEmployee();
		    
		assertEquals(employees.size(), fetchedEmployees.size());
		assertEquals(employees, fetchedEmployees);
	}
}