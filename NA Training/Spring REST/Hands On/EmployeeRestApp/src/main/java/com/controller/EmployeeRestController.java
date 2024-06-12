package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Company;
import com.model.Employee;

@RestController
public class EmployeeRestController {

	@RequestMapping("/employees")
	public List<Employee> getAllEmployees() {
		Company company = new Company();
		return company.getEmpList();
	}
}