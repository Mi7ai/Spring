package pack2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 

@Controller
@RequestMapping("/customer")
public class CustomerController {
//	inject dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
//		get customer from dao
		List<Customer> theCustomers = customerDAO.getCustomers();
		
//		add customers to model
		theModel.addAttribute("customers",theCustomers);
		
		return "listCustomers";
	}
}
