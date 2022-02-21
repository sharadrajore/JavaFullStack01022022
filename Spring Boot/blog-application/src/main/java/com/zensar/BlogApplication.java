package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		System.out.println("RAM");
		SpringApplication.run(BlogApplication.class, args);
		System.out.println("Seeta");

	}

}
