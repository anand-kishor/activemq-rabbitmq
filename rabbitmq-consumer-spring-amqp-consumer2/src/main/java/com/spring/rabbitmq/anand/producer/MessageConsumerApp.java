package com.spring.rabbitmq.anand.producer;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MessageConsumerApp {

	final static String queue_name="product_message_queue";
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(RabbitMQConfig.class);
		MessageReceiver receiver=(MessageReceiver)ctx.getBean("receiver");
		receiver.getCountDownLatch().await(20000,TimeUnit.SECONDS);
		
	}

}
