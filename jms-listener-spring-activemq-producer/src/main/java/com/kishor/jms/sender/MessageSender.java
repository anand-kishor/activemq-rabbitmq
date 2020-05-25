package com.kishor.jms.sender;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.kishor.jms.model.Product;

@Component
public class MessageSender {
	@Autowired
	JmsTemplate jmsTemplate;
	public void sendMessage(final Product product)
	{
		jmsTemplate.convertAndSend(new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				ObjectMessage objectMessage=session.createObjectMessage(product);
				
				return objectMessage;
			}});
	}
	
	

}
