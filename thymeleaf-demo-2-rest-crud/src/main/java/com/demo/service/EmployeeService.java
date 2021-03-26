package com.demo.service;

import java.util.List;

import com.demo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	Employee findById(int id);
	void save(Employee employee);
	void deleteById(int id);
}
