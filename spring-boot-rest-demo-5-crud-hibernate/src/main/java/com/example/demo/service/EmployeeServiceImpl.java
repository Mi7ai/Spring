package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO edao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO edao) {
		this.edao = edao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return edao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return edao.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		edao.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		edao.deleteById(id);
	}

}
