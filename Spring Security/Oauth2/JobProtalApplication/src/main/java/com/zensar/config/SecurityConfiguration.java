package com.zensar.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	/*@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService);
		
		// Authentication 
		
		/*auth.inMemoryAuthentication()
		.withUser("tom")
		.password("tom@123")
		.roles("USER")
		.and()
		.withUser("jerry")
		.password("jerry@123")
		.roles("ADMIN");
		
		
	}
	

	
	
	
	*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Authorization 
		http.csrf().disable()
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.oauth2Login();
		
		
		
	}







/*	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception {
		return super.authenticationManager();
	}*/
	
	
	
	

}
