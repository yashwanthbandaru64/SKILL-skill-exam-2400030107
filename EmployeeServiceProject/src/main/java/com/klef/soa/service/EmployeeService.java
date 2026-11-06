package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee e);
	List<Employee> displayAll();
	String deleteEmpById(Long id);
	Employee updateEmp(Employee e);
	Employee displayById(Long id);
	List<Employee> displayByEmployeeName(String name);
	List<Employee> displayByEmployeeDepartment(String dep);
	

}
