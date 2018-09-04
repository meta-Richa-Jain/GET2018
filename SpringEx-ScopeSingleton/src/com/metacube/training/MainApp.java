package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      ScopeCheck sc1 = (ScopeCheck) context.getBean("scopeCheck");

	      sc1.setScope("singleton");
	      System.out.println(sc1.getScope());

	      ScopeCheck sc2 = (ScopeCheck) context.getBean("scopeCheck");
	      System.out.println(sc2.getScope());
	   }

}