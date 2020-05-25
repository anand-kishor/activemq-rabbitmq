package com.anand;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.anand.config.AppConfig;
import com.anand.sender.MessageSender;

public class MessageProducerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		MessageSender sender=context.getBean(MessageSender.class);
		sender.sendMessage("hi saurav h r u");
		System.out.println("message successfully send");
		((AbstractApplicationContext) context).close();

	}

}
