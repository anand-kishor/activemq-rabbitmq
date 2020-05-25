package com.anand.email.mail.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anand.email.mail.Email;

public class AppTest {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		Email email=(Email)ctx.getBean("email");
		
		//String name="leave letter";
		String message="i am not feeling well,i m taking sick leave";
		email.sendEmail( message);
		System.out.println("email send successfully");

	}

}
