package com.antra.archive.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service; 

@Service
public class MailSenderService {
	@Autowired
	private JavaMailSender javaMailSender;
	
    @Scheduled(fixedDelay = 100000)
    public void sendMail() throws MessagingException {
    	MimeMessage message = javaMailSender.createMimeMessage();
    	try {
    		MimeMessageHelper helper = new MimeMessageHelper(message, true);
    		helper.setSubject("Test email");
    		helper.setTo("junjie.li@northwestern.edu");
    		helper.setText("This is an auto generated message", true);
        	javaMailSender.send(message);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}		
    }
}
