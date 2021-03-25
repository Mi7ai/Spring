package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
//	without service layer
	private EmployeeDAO edao;
	
	@Autowired
	public EmployeeRestController(EmployeeDAO edao) {
		this.edao = edao;
	}
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return edao.findAll();
	}
}
