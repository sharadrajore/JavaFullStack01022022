package com.zensar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zensar.Item;
import com.zensar.Order;

@Configuration
@ComponentScan("com.zensar")
@PropertySource("data.properties")
public class JavaConfig {
	
/*	@Bean(name="order")
	public Order getOrder() {
		return new Order(getItem(),"Purchase Title");
	}
	
	@Bean
	public Item getItem() {
		return new Item("Mobile", 20000.00);
	} */

}
