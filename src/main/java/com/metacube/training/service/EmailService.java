package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.metacube.training.model.User;

@Service
public class EmailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(User user) {

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("richa.jain1@metacube.com");
		mail.setSubject("FORGET PASSWORD");
		mail.setText("Hello " + user.getFirstName() + " " + user.getLastName() + " your Password is : "
				+ "BLABLA");
		javaMailSender.send(mail);
	}
}