package com.zensar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zensar.config.JavaConfig;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

		Order order1=(Order)context.getBean("myOrder");
		
		Order order2=(Order)context.getBean("myOrder");
		
		//Item item=(Item)context.getBean("item");
		
		System.out.println(order1.hashCode());
		System.out.println(order2.hashCode());
	}
}
