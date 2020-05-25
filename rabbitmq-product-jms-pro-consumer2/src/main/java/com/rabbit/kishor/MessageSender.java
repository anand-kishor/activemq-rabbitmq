package com.rabbit.kishor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MessageSender {
	private static final String QUEUE_NAME="product_queue";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		try (
			Connection connection=factory.newConnection();
			Channel channel=connection.createChannel())
		{
			channel.queueDeclare(QUEUE_NAME,false,false,false,null);
			Product product=new Product();
			product.setProductId(1002);
			product.setName("laptop");
			product.setQuantity(100);
			byte[] byteArray=getByteArray(product);
			channel.basicPublish("", QUEUE_NAME, null, byteArray);
			System.out.println("[X] send  "+product+" ");
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
	}
	private static byte[] getByteArray(Product product) throws IOException {
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		ObjectOutputStream os=new ObjectOutputStream(out);
		os.writeObject(product);
		return out.toByteArray();
	}

}
