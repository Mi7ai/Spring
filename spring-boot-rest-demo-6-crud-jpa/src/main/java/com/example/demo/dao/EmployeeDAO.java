package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeDAO {
	List<Employee> findAll();
	Employee findById(int id);
	void save(Employee employee);
	void deleteById(int id);
}
