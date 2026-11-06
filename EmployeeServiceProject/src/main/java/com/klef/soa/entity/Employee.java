package com.klef.soa.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee_table")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 50,nullable = false)
  private String empname;
  @Column(length = 50 ,nullable = false)
  private String department;
  @Column(nullable = false ,unique = true)
  private String email;
  @Column(nullable = false)
  private double salary;
  @Column(nullable = false)
  private double experience;
  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getEmpname() {
    return empname;
  }
  public void setEmpname(String empname) {
    this.empname = empname;
  }
  public String getDepartment() {
    return department;
  }
  public void setDepartment(String department) {
    this.department = department;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public double getSalary() {
    return salary;
  }
  public void setSalary(double salary) {
    this.salary = salary;
  }
  public double getExperience() {
    return experience;
  }
  public void setExperience(double experience) {
    this.experience = experience;
  }
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
  @Override
  public String toString() {
    return "Employee [id=" + id + ", empname=" + empname + ", department=" + department + ", email=" + email
        + ", salary=" + salary + ", experience=" + experience + ", createdAt=" + createdAt + ", updatedAt="
        + updatedAt + "]";
  }
  
  

}