package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.klef.soa.entity.Employee;
import com.klef.soa.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repo;
	

	@Override
	public Employee addEmployee(Employee e) {
		return repo.save(e);
	}

	@Override
	public List<Employee> displayAll() {
		return repo.findAll();
	}

	@Override
	public String deleteEmpById(Long id) {
		Optional<Employee> optional= repo.findById(id);
		if(optional.isPresent())
		{
			repo.deleteById(id);
			return "Record Deleted Successfully";
		}
		else
		{
			return "Record Not Found to delete with the Provided Id";
		}
	}

	@Override
	public Employee updateEmp(Employee e) {
		Optional<Employee> optional= repo.findById(e.getId());
		if(optional.isPresent())
		{
			Employee emp=optional.get();
			emp.setEmpname(e.getEmpname());
			emp.setDepartment(e.getDepartment());
			emp.setExperience(e.getExperience());
			emp.setEmail(e.getEmail());
			return repo.save(emp);
			
		}
		else
		{
			return null;
		}
	}

	@Override
	public Employee displayById(Long id) {
		return repo.findById(id).orElse(null);
		
	}

	@Override
	public List<Employee> displayByEmployeeName(String name) {
		return repo.findByEmpname(name);
	}

	@Override
	public List<Employee> displayByEmployeeDepartment(String emp) {
		return repo.findByDepartment(emp);
	}

}
