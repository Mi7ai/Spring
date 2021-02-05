package pack1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("name")
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
	public String shoutName2(HttpServletRequest request, Model model) {
//		read request param, convert data
		String studentName = request.getParameter("studentName2");
		studentName = studentName.toUpperCase();
		String result = "Hi "+studentName; 
//		message is the name, result is the value
		model.addAttribute("messageStudentName2",result);
//		the return is the view
		return "processFormPage";
		
	}
	
//	read form data and add it to model
	@RequestMapping("processForm3")
	public String shoutName3(@RequestParam("studentName3") String studentName3, Model model) {
//		read request param, convert data
		studentName3 = studentName3.toUpperCase();
		String result = "Yo "+studentName3; 
//		message is the name, result is the value
		model.addAttribute("messageStudentName3",result);
//		the return is the view
		return "processFormPage";
		
	}
}
