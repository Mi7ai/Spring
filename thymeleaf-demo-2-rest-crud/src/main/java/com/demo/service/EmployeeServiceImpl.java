package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeRepository;
import com.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository erepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository erepo) {
		this.erepo = erepo;
	}

	@Override
	public List<Employee> findAll() {
		return erepo.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = erepo.findById(id);
		Employee emp = null;
		if (result.isPresent()) {
			emp = result.get();
		}else {
			throw new RuntimeException("Did not find employee id: "+id);
		}
		return emp;
	}

	@Override
	public void save(Employee employee) {
		erepo.save(employee);
	}

	@Override
	public void deleteById(int id) {
		erepo.deleteById(id);
	}

}
