package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

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
	public List<Employee> findAll() {
		Session cs = em.unwrap(Session.class);
		
		Query<Employee> q = cs.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = q.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Session cs = em.unwrap(Session.class);
		
		Employee emp= cs.get(Employee.class, id);
		 
		return emp;
	}


	@Override
	public void save(Employee employee) {
		Session cs = em.unwrap(Session.class);
//		if id is=0 save/insert else update
		cs.saveOrUpdate(employee);
	}


	@Override
	public void deleteById(int id) {
		Session cs = em.unwrap(Session.class);

		Query q = cs.createQuery("delete from Employee where id=:param");
		q.setParameter("param", id);
		
		q.executeUpdate();
	}

}
