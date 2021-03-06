package com.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Customer;
import com.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	private CustomerService cs;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return cs.getCustomers();
	}
	

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer c = cs.getCustomer(customerId);
		
		if (c == null) {
			throw new CustomerNotFoundException("Customer id not found "+customerId);
		}
		
		return c;
	}
//	add new customer - POST
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		cs.saveCustomer(theCustomer);
//		dao inserts if id is set to zero because of saveOrUpdate method
		theCustomer.setId(0);
		
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		cs.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer theCustomer = cs.getCustomer(customerId);
		
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found "+customerId);
		}
		
		cs.deleteCustomer(customerId);
		
		return "Deleted customer with id "+customerId;
		
	}
}
