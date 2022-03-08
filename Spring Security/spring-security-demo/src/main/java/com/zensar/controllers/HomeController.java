package com.zensar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.AuthenticationRequest;
import com.zensar.util.JwtUtils;

@RestController
public class HomeController {
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	 // http://localhost:8080/authenticate
	@PostMapping("/authenticate")
	public ResponseEntity<String> authentication(@RequestBody AuthenticationRequest request) {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
		}catch(BadCredentialsException e) {
			throw new BadCredentialsException(request.getUsername());
		}
		
		//return jwtUtils.generateToken(request.getUsername());
		
		return new ResponseEntity<String>(jwtUtils.generateToken(request.getUsername()),HttpStatus.OK);
		
	}
	
	
	
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
