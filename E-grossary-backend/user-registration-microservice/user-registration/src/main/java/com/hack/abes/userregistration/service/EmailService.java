package com.hack.abes.userregistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}
	
	public void sendEmail(SimpleMailMessage email) {
		javaMailSender.send(email);
		
	}

}
