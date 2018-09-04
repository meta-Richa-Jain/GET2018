package com.metacube.training;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	    CollectionExamples ce=(CollectionExamples)context.getBean("collectionExamples");

	    List addressList = ce.getAddressList();
	    Set addressSet = ce.getAddressSet();
	    Map addressMap = ce.getAddressMap();
	}


}
