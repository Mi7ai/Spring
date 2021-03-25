package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	private EntityManager em;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager em) {
		this.em = em;
	}


	@Override
	@Transactional
	public List<Employee> findAll() {
		Session cs = em.unwrap(Session.class);
		
		Query<Employee> q = cs.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = q.getResultList();
		
		return employees;
	}

}
