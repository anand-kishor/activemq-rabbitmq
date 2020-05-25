package com.anand;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.anand.config.AppConfig;
import com.anand.service.MailService;
import com.anand.service.MailServiceImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		MailService mailService=ctx.getBean("mailService",MailServiceImpl.class);
		String  senderEmailId="anandkishor010@gmail.com";
		String receiverEmailId="anandkishorejava@gmail.com";
		String subject="leave lettet";
		String message="i am suffering from fiver";
	mailService.sendEmail(senderEmailId, receiverEmailId, subject, message);
	ctx.close();
	}

}
