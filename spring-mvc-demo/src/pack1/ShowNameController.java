package pack1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowNameController {
	
	@RequestMapping("showForm")
	public String showForm() {
//		the return is the view
		return "showFormPage";
	}
	
	@RequestMapping("processForm")
	public String processForm() {
//		the return is the view
		return "processFormPage";
	}
}
