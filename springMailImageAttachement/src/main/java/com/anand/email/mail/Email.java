package com.anand.email.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
public class Email {
	private JavaMailSender javaMailSender;
	
	public void setMailSender(JavaMailSender javaMailSender)
	{
		this.javaMailSender=javaMailSender;
	}
	
	public void sendEmail(String message)
	{
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
			
		try {
			MimeMessageHelper helper=new  MimeMessageHelper(mimeMessage,true);
			helper.setFrom("anandkishor010@gmail.com");
			helper.setTo("anandkishor010@gmail.com");
			helper.setSubject("leave letter");
			helper.setText(message);
			FileSystemResource file=new FileSystemResource("f:\\work\\image.jpg");
			helper.addAttachment(file.getFilename(), file);
			javaMailSender.send(mimeMessage);
		}
		catch(MessagingException e)
		{
			e.printStackTrace();
		}
    }
}