package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Employee;
import com.klef.soa.service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	public String demo()
	{
		return "Employee Service Project";
	}

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/instance")
	private String instance()
	{
		return "port number" + port;
	}
	
	@PostMapping("/addemp")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e)
	{
		Employee emp= service.addEmployee(e);
		return ResponseEntity.status(201).body(emp);

	}
	@GetMapping("displayall")
	public ResponseEntity<List<Employee>> displayAll()
	{
		List<Employee> list= service.displayAll();
		return ResponseEntity.status(200).body(list);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<String> deleteById( @RequestParam Long id)
	{
		 String response=  service.deleteEmpById(id);
		 return ResponseEntity.status(200).body(response);
		
	}
	
	@PutMapping("update")
	public ResponseEntity<?> updateEmp( @RequestBody Employee emp)
	{
		Employee e= service.updateEmp(emp);
		if(e!=null) {
		return ResponseEntity.status(200).body(e);
		}
		else
		{
			return ResponseEntity.status(404).body("Id Not Found to Update");
		}
	}
	
	@GetMapping("displaybyid/{id}")
	public ResponseEntity<?> displayByID(@PathVariable Long id)
	{
		Employee e=service.displayById(id);
		if(e!=null) {
		return ResponseEntity.status(200).body(e);
		}
		else
		{
			return ResponseEntity.status(404).body("Employee ID Not Found");
		}
	}
	
	@GetMapping("displaybyname/{ename}")
	public ResponseEntity<List<Employee>> displayByNmae(@RequestParam String ename)
	{
		List<Employee> list= service.displayByEmployeeName(ename);
		
		return ResponseEntity.status(200).body(list);
	
	}
	
	@GetMapping("displaybydepart/{dep}")
	public ResponseEntity<List<Employee>> displayByDepartment(@PathVariable String dep)
	{
		List<Employee> list=service.displayByEmployeeDepartment(dep);
		
		return ResponseEntity.status(200).body(list);
		
		
	}
	
	

}
