package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"beans.xml");
			TextEditor textEditor = (TextEditor) context.getBean("textEditor");
			textEditor.spellCheck();
		} catch (Exception e) {
			System.out.println("Class not found or bean  not found");
		}
	}

}
