package com.zensar.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobProtalController {
	
	// http://localhost:8080/
	@GetMapping("/")
	public String getMessage(Principal principal) {
		return "Hello "+principal.getName()+" "+"How are you ?";
	}

}
