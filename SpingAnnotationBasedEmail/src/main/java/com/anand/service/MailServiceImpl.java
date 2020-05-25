package com.anand.service;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(final String  senderEmailId,final String receiverEmailId,final  String subject,final String message) {
		
		// TODO Auto-generated method stub
		MimeMessagePreparator mimePreparator=new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// TODO Auto-generated method stub
				mimeMessage.setFrom();
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmailId));
				mimeMessage.setSubject(subject);
				mimeMessage.setText(message);
			}
			
		};
		try {
			mailSender.send(mimePreparator);
			System.out.println("message send hurrey ! ");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
