package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		// activate the Spring IOC container
		
		ApplicationContext ctx= new ClassPathXmlApplicationContext("aplicationContext.xml");

	}

}
