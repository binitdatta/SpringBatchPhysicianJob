package com.rollingstone.physician.ranker.driver;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) throws Exception {
		new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

	}
}