package com.klef.soa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Employee;
import com.klef.soa.repository.EmployeeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    void testFindAllEmployees() {
        List<Employee> employees = repository.findAll();

        assertNotNull(employees);
        assertFalse(employees.isEmpty());

        System.out.println("Total Employees: " + employees.size());
    }

    @Test
    void testFindEmployeeById() {
        List<Employee> employees = repository.findAll();
        assertFalse(employees.isEmpty());
        Optional<Employee> employee = repository.findById(1L);

        assertTrue(employee.isPresent());
        assertEquals(1L, employee.get().getId());

        System.out.println("Employee ID: " + employee.get().getId());
        System.out.println("Employee Name: " + employee.get().getEmpname());
    }

    @Test
    void testFindEmployeeByEmail() {
        Optional<Employee> employees = repository.findByEmail("admin@gmail.com");
        assertTrue(employees.isPresent());
        assertEquals("admin@gmail.com", employees.get().getEmail());
        System.out.println("Email: " + employees.get().getEmail());
     
    }

    @Test
    void testFindEmployeeByInvalidEmail() {
        Optional<Employee> employees =
                repository.findByEmail("notfound@example.com");

        assertTrue(employees.isPresent());
    }

    @Test
    void testDatabaseConnection() {
        long count = repository.count();

        assertTrue(count >= 0);
        System.out.println("Total Employees in Database: " + count);
    }

    @Test
    void testEmployeeDetails() {
        List<Employee> employees = repository.findAll();
        assertFalse(employees.isEmpty());

        Employee employee = employees.get(0);

        assertNotNull(employee.getId());
        assertNotNull(employee.getEmpname());
        assertNotNull(employee.getDepartment());
        assertNotNull(employee.getEmail());

        System.out.println("Name: " + employee.getEmpname());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("Experience: " + employee.getExperience());
    }

    @Test
    void testTotalEmployeeCount() {
        long count = repository.count();
        assertEquals(10L, count);
    }


}