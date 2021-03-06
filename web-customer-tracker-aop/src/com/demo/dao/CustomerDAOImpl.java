package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDAOImpl implements CustomerDAO {
//	inject session factory
	@Autowired
	private SessionFactory f;
	
	@Override
	public List<Customer> getCustomers() {
//		get hibernate session
		Session s = f.getCurrentSession(); 
		
//		create query
		Query<Customer> q1 = s.createQuery("from Customer order by firstName",Customer.class);
		
//		get customers list
		List<Customer> customers = q1.getResultList();
		
//		return customers list
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
//		get hibernate session
		Session s = f.getCurrentSession(); 
		
		s.save(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
//		get hibernate session
		Session s = f.getCurrentSession(); 
		
//		get customer from db
		Customer c = s.get(Customer.class, theId);
		
		return c;
	}

	@Override
	public void updateCustomer(Customer theCustomer) {
//		get hibernate session
		Session s = f.getCurrentSession(); 
		
		s.update(theCustomer);
	}

	@Override
	public void deleteCustomer(int theId) {
//		get hibernate session
		Session s = f.getCurrentSession(); 
//		Customer.class is not nedeed because the return type of the query is not specific
//		if added it will output and error like "queries cannot be typed"
		Query q = s.createQuery("delete from Customer where id=:n");
		q.setParameter("n", theId);
		
//		alternative delete
		q.executeUpdate();
//		alternative delete
		
	}
}
