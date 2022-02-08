package com.zensar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myOrder")
@Scope("singleton")
public class Order {
	
	@Autowired
	private Item item;
	
	@Value("${title}")
	private String title;
	
	public Order() {
		System.out.println("Inside Order()");
	}
	
	public Order(Item item, String title) {
		System.out.println("Inisde Order(Item item, String title)");
		this.item = item;
		this.title = title;
	}
	
	
	
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		System.out.println("Inside setTitle(String title)");
		this.title = title;
	}
	
	public String toString() {
		return title + " - " + item;
	}

	
	/*@PostConstruct
	public void myInit() {
		System.out.println("Inside myInit");
		
	}


	@PreDestroy
	public void destroy()  {
		System.out.println("Inside destroy !!!");
		
	}*/
	
	
	
}
