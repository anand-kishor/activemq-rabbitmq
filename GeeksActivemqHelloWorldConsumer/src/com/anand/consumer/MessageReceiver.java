package com.anand.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceiver {
	private static final String url=ActiveMQConnection.DEFAULT_BROKER_URL;
	private static final String subject="geeks_queue";
	public static void main(String[] args) throws JMSException {
		// TODO Auto-generated method stub
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(url);
		Connection connection=connectionFactory.createConnection();
		connection.start();
		Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//Destination destination=session.createQueue(subject);
		Destination destination=session.createTopic(subject);
		MessageConsumer consumer=session.createConsumer(destination);
		Message message=consumer.receive();
		if(message instanceof TextMessage)
		{
			TextMessage textMessage=(TextMessage)message;
			System.out.println("received message "+textMessage.getText());
		}
		connection.close();
	}

}
