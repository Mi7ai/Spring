package com.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@GetMapping("/students")
	public List<Student> getStudent() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Mike","Towers"));
		students.add(new Student("Jake","Towers"));
		students.add(new Student("Tony","Towers"));
		
		return students;
	}
}
