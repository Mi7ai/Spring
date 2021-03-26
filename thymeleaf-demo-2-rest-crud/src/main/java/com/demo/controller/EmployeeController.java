package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
//	without service layer
	private EmployeeService eserv;
	
	@Autowired
	public EmployeeController(EmployeeService eserv) {
		this.eserv = eserv;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get employees from db
		List<Employee> theEmployees = eserv.findAll();
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "employees/listEmployees";
	}
}
