package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		TextEditor textEditor = null;
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"beans.xml");
			textEditor = (TextEditor) context.getBean("textEditor");
			
		} catch (Exception e) {
			System.out.println("Class not found or bean  not found");
		}
		textEditor.spellCheck();
	}

}