package com.anand.email.mail;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class Email {
	private JavaMailSender javaMailSender;
	public void setMailSender(JavaMailSender javaMailSender)
	{
		this.javaMailSender=javaMailSender;
	}
	public void sendEmail(String from,String to,String subject,final String message)
	{
		MimeMessagePreparator messagePreparator=new MimeMessagePreparator()
				{

					@Override
					public void prepare(MimeMessage mimeMessage) throws Exception {
						// TODO Auto-generated method stub
						mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
						mimeMessage.setFrom(new InternetAddress(from));
						mimeMessage.setSubject(subject);
						mimeMessage.setText(message);
					}
			
				};
				javaMailSender.send(messagePreparator);
	}

}
