package com.ssafy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.model.dto.Product;


public class BeanTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/ssafy/web/applicationContext.xml");	   
		Product product = (Product) ctx.getBean("product");
		System.out.println(product);
	}
}
