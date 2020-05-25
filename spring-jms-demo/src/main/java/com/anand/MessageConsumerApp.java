package com.anand;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.anand.config.AppConfig;
import com.anand.receiver.MessageReceiver;
import com.anand.sender.MessageSender;

public class MessageConsumerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		MessageReceiver receive=(MessageReceiver)context.getBean("messageReceiver");
		String response=receive.receiveMessage();
		System.out.println("message received :"+response);
		((AbstractApplicationContext) context).close();

	}

}
