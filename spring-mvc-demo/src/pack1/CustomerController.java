package pack1;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
//	trim white space of strings for lastName field in case the input is white spaces
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
//		trim to null
		StringTrimmerEditor s = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, s);
	}
	
//	show the form
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		Customer theCustomer = new Customer();
//		customer name comes from customerForm
		theModel.addAttribute("customer",theCustomer);
		
		return "customerForm";
	}
	
//	process the form
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer")Customer theCustomer, BindingResult theBindingResult) {
//		System.out.println(theBindingResult);
		if (theBindingResult.hasErrors()) {
			return "customerForm";
		}
		
		return "customerConfirmation";
		
	}
}
