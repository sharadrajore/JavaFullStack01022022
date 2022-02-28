package com.zensar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Blog API ",version = "1.1.0",description = "About Blog Application"))
public class BlogApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		System.out.println("RAM");
		SpringApplication.run(BlogApplication.class, args);
		System.out.println("Seeta");

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return super.configure(builder);
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	
	

}
