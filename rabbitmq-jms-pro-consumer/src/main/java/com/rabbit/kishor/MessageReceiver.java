package com.rabbit.kishor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class MessageReceiver {

	private static final String QUEUE_NAME="sender_queue";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		System.out.println("[]* waiting for message to exit press CTRL+C");
		DeliverCallback deliverCallBack=(consumerTag,delivery)->{
			String message=new String(delivery.getBody(),"UTF-8");
			System.out.println("[x] received:"+message+"" );
		};
		channel.basicConsume(QUEUE_NAME,true, deliverCallBack,consumerTag ->{});

		
	}

}
