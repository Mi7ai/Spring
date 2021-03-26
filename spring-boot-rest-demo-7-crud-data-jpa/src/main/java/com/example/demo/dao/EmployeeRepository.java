package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;

//crud methods for free baby
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
