package pack2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CustomerService;
 

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
}
