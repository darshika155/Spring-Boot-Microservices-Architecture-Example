package com.example.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
	
	@GetMapping("/userServiceFallback")
	public String userServiceFallBackMethod() {
		
		return "User Service is taking longer time than expected";
	}
	
	@GetMapping("/departmentServiceFallback")
	public String departmentServiceFallBackMethod() {
		
		return "Department Service is taking longer time than expected";
	}

}
