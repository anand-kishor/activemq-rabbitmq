package com.spring.rabbitmq.anand.producer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;

public class MessageProducerApp {

	final static String queue_name="message_queue";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(RabbitMQConfig.class);
		RabbitTemplate rabbitTemplate=(RabbitTemplate)ctx.getBean("rabbitTemplate");
		rabbitTemplate.convertAndSend(queue_name,"Hello anand !");
		System.out.println("message success full send to queue!!!");
		ctx.close();
	}

}
