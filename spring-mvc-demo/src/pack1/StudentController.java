package pack1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	//	show the form
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		Student theStudent = new Student();
//		student name comes from studentForm
		theModel.addAttribute("student",theStudent);
		
		return "studentForm";
	}
	
//	process the form
	@RequestMapping("/processForm")
//	student from modelAttribute form
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		return "studentConfirmation";
	}
}
