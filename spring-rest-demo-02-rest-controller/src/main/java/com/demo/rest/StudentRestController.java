package com.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> students ;
	
	@PostConstruct
	public void loadData() {
		students = new ArrayList<Student>();
//		hardcoded example for the moment
		students.add(new Student("Mike","Towers"));
		students.add(new Student("Jake","Towers"));
		students.add(new Student("Tony","Towers"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudent() {
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) throws Exception {
		Student theStudent = null;
		 try {
			theStudent =  students.get(studentId);
		} catch (IndexOutOfBoundsException e) {
//			i cant set up this message because i have my own class 
			throw new StudentNotFoundException("Student id not found");
		} 
		 
		 return theStudent;
	}
	

}
