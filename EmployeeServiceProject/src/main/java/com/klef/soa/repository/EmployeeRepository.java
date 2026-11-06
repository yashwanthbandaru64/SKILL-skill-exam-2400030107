package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Employee;
import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByEmpname(String empname);
	List<Employee> findByDepartment(String department);
	Optional<Employee> findByEmail(String email);
	

	

}
