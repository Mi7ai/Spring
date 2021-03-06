package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.service.CustomerService;
 

@Controller
@RequestMapping("/customer")
public class CustomerController {
//	inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
//		get customer from dao
		List<Customer> theCustomers = customerService.getCustomers();
		
//		add customers to model
		theModel.addAttribute("customers",theCustomers);
		
		return "listCustomers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
// 		create the model attribute to bind form data
		Customer c = new Customer();
		
		theModel.addAttribute("customer",c);
		
		return "addCustomerForm";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
//		get customer from our service
		Customer c = customerService.getCustomer(theId);
		
//		set customer as a model attribute to prepopulate the form
		theModel.addAttribute("customer",c);
		
		return "updateCustomerForm";
	}
 
	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.updateCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
}
