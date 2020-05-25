package com.saurav;

import javax.jms.JMSException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jms.support.converter.MessageConversionException;

import com.saurav.config.AppConfig;
import com.saurav.model.Product;
import com.saurav.receiver.MessageReceiver;

public class MessageConsumerApp {

	public static void main(String[] args) throws MessageConversionException, JMSException {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		MessageReceiver receive=(MessageReceiver)ctx.getBean("messageReceiver");
		Product product=receive.receiveMessage();
		System.out.println("message is received :"+product);
		((AbstractApplicationContext) ctx).close();


	}

}
