package com.zensar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	// http://localhost:8080/
	@GetMapping("/")
	public String home() {
		return "<h1> Welcome !!! </h1>";
	}
	
	// http://localhost:8080/user
	@GetMapping("/user")
	public String user() {
		return "<h1> Welcome User !!! </h1>";
	}
	
	// http://localhost:8080/admin
	@GetMapping("/admin")
	public String admin() {
		return "<h1> Welcome Admin !! </h1>";
	}

}
