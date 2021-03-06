package com.demo.service;

import java.util.List;

import com.demo.dao.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public void updateCustomer(Customer theCustomer);
	
	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
