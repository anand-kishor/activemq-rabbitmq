package com.rabbit.kishor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MessageSender {
	private static final String QUEUE_NAME="sender_queue";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		try (
			Connection connection=factory.newConnection();
			Channel channel=connection.createChannel())
		{
			channel.queueDeclare(QUEUE_NAME,false,false,false,null);
			String message="Hello world";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
			System.out.println("[X] send  "+message+" ");
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
	}

}
