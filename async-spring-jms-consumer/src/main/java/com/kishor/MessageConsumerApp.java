package com.kishor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.kishor.config.AppConfig;

public class MessageConsumerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		try {
			Thread.sleep(600000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
     ((AbstractApplicationContext)ctx).close();
	}

}
