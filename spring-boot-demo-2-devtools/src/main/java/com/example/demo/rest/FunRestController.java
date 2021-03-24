package com.example.demo.rest;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FunRestController {
	@GetMapping("/")
	public String sayHello() {
		return "Hi, time on server is: "+LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getWorkout() {
		return "Running like madman";
	}
}
