package com.myntra.service;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendMail() throws Exception {
		MimeMessage message = this.mailSender.createMimeMessage();
		message.setFrom(new InternetAddress("rbattila@evoketechnologies.com"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress("pavan.battila@gmail.com"));
		message.setSubject("Conformation Mail ");
		message.setText("Hai Roja, Your Order Creation is Successfully done....");
		mailSender.send(message);

	}
}
