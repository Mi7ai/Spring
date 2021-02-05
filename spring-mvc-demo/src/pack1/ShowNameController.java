package pack1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowNameController {
	
	@RequestMapping("showForm")
	public String showForm() {
//		the return is the view
		return "showFormPage";
	}
//	processForm name if for the form action in showFormPage
	@RequestMapping("processForm")
	public String processForm() {
//		the return is the view
		return "processFormPage";
	}
	
//	read form data and add it to model
	@RequestMapping("processForm2")
	public String shoutName(HttpServletRequest request, Model model) {
//		read request param, convert data
		String studentName = request.getParameter("studentName2");
		studentName = studentName.toUpperCase();
		String result = "Hi "+studentName; 
//		message is the name, result is the value
		model.addAttribute("message",result);
//		the return is the view
		return "processFormPage";
		
	}
}
