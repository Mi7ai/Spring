package service;

import java.util.List;

import pack2.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public void updateCustomer(Customer theCustomer);
	
	public Customer getCustomer(int theId);

}
