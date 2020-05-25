package com.kishor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.kishor.config.AppConfig;
import com.kishor.model.Product;
import com.kishor.sender.MessageSender;


public class MessageProducerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		MessageSender sender=ctx.getBean(MessageSender.class);
		Product product=new Product();
		product.setProductId(100);
		product.setName("samsung");
		product.setQuqntity(10);
		sender.sendMessage(product);
		System.out.println("message send successfully");
		((AbstractApplicationContext) ctx).close();


	}

}
