package com.kishor.jms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.kishor.jms.config.AppConfig;
import com.kishor.jms.model.Product;
import com.kishor.jms.sender.MessageSender;

public class MessageProducerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		MessageSender sender=(MessageSender)ctx.getBean(MessageSender.class);
		Product product=new Product();
		product.setProductId(10);
		product.setName("samsung");
		product.setQuantity(100);
		sender.sendMessage(product);
		System.out.println("product message successfully send");
		((AbstractApplicationContext)ctx).close();
	}

}
