package com.anand.sender;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {
	private static  String url=ActiveMQConnection.DEFAULT_BROKER_URL;
	private static String queueName="MESSAGE_QUEUES";

	public static void main(String[] args) throws JMSException {
		// TODO Auto-generated method stub
		System.out.println("url of activemq "+url);
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(url);
		Connection connection=connectionFactory.createConnection();
		connection.start();
		Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		
		Destination destination=session.createQueue(queueName);
		MessageProducer producer=session.createProducer(destination);
		
		TextMessage message=session.createTextMessage("Hi anand h r you");
		producer.send(message);
		System.out.println("message "+message.getText()+"successfully send");
		connection.close();
		
		

	}

}
