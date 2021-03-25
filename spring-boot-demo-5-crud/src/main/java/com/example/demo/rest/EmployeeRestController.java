package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
//	without service layer
	private EmployeeService eserv;
	
	@Autowired
	public EmployeeRestController(EmployeeService eserv) {
		this.eserv = eserv;
	}
	
//	get all employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return eserv.findAll();
	}
	
//	get all employees by id
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee emp =  eserv.findById(employeeId);
		
		if (emp == null){
			throw new RuntimeException("Employee id not found: "+employeeId);
		}
		
		return emp;
	}
	
//	add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
//		in order to insert it I must set it to zero so that the dao hibernate
//		impl can insert it
		employee.setId(0);
		eserv.save(employee);
		
		return employee;
	}
	
//	update new employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		eserv.save(employee);
		
		return employee;
	}
	
//	delete new employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee emp =  eserv.findById(employeeId);
		
		if (emp == null){
			throw new RuntimeException("Employee id not found: "+employeeId);
		}
		eserv.deleteById(employeeId);
		
		return "Deleted employee: "+employeeId;
	}
}
