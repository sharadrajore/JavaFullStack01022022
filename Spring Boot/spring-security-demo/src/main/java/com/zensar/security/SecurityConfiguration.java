package com.zensar.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// Authentication 
		
		auth.inMemoryAuthentication()
		.withUser("tom")
		.password("tom@123")
		.roles("USER")
		.and()
		.withUser("jerry")
		.password("jerry@123")
		.roles("ADMIN");
		
		
	}
	
	
	
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Authorization 
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/").permitAll()
		.and()
	//	.httpBasic();
		.formLogin();
		
		
		
	}







	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	
	

}
