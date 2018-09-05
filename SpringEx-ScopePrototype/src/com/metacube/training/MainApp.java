package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		
		ScopeCheck sc1 = null;
		ScopeCheck sc2 = null;
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"beans.xml");
			ScopeCheck sc1 = (ScopeCheck) context.getBean("scopeCheck");
			sc1.setScope("prototype");
			System.out.println(sc1.getScope());
			
			ScopeCheck sc2 = (ScopeCheck) context.getBean("scopeCheck");
			// need to set every time
			System.out.println(sc2.getScope());
			
		} catch (Exception e) {
			System.out.println("Class not found or bean  not found");
		}
		
		

		
	}

}
