package com.rabbit.kishor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class MessageReceiver {

	private static final String QUEUE_NAME="product_queue";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		System.out.println("[]* waiting for message to exit press CTRL+C");
		DeliverCallback deliverCallBack=(consumerTag,delivery)->{
			byte[] byteArray=delivery.getBody();
			try {
				Product product=(Product)deserialize(byteArray);
				System.out.println("[x] received :"+product+"");
			}
			catch(Exception exe)
			{
				exe.printStackTrace();
			}
		};
		channel.basicConsume(QUEUE_NAME,true, deliverCallBack,consumerTag ->{});

		
	}
	private static Object deserialize(byte[] byteArray) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ByteArrayInputStream in=new ByteArrayInputStream(byteArray);
		ObjectInputStream is=new ObjectInputStream(in);
		return is.readObject();
	}

}
