package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
	private EntityManager em;
	
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Employee> findAll() {
		Query q = em.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = q.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Employee emp= em.find(Employee.class, id);
		 
		return emp;
	}

	@Override
	public void save(Employee employee) {
//		save or update the employee
		em.merge(employee);
//		updates with id from db so we can get generated id for save/insert
		employee.setId(employee.getId());
	}

	@Override
	public void deleteById(int id) {

		Query q = em.createQuery("delete from Employee where id=:param");
		q.setParameter("param", id);
		
		q.executeUpdate();
	}

}
