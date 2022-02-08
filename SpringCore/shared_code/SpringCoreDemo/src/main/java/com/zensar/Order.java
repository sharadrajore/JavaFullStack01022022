package com.zensar;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public  class Order {
	
	private Item item;
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
