package com.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
//	error for handling outside or student range bound
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
//	error for handling text or any general bad input
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e){
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		change this for customer error message
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
