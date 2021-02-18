package pack2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
