package com.example.demo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FunRestController {
	@Value(value = "${cs.name}")
	private String name;
	
	@Value(value = "${cs.rank}")
	private String rank;
	
	@GetMapping("/")
	public String sayHello() {
		return "Hi, time on server is: "+LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getWorkout() {
		return "Running like madman";
	}
	
	@GetMapping("/profileInfo")
	public String getProfile() {
		return "FunRestController [name=" + name + ", rank=" + rank + "]";
	}

 
	
}
