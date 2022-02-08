package com.zensar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    //	ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");// Ioc container
    	
    //	Order order=(Order)context.getBean("order");
    	
    	ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
    	
    	//ApplicationContext context2=new ClassPathXmlApplicationContext("context.xml");
    	
    	
    	// JVM
    	
    //	AbstractApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
    //	File file=new File("context.xml");
    //	Resource resource=new FileSystemResource(file);
    //	BeanFactory context=new XmlBeanFactory(resource);
    	
    //	((AbstractApplicationContext) context).registerShutdownHook();
    	
    	Order order1=context.getBean("newOrder", Order.class);
    	System.out.println(order1);
    	
    
    	
    	
   // 	System.out.println(order);
    	
    }
}
