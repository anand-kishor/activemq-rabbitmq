package com.anand.receiver;

import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;


import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.stereotype.Component;

import com.anand.sender.MessageSender;


@Component
public class MessageReceiver {
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired 
	SimpleMessageConverter messageConverter;
	public 	String receiveMessage()
	{
		try {
		org.springframework.messaging.Message<String> message=(org.springframework.messaging.Message<String>) jmsTemplate.receive();
		String response=(String)messageConverter.fromMessage(message, SimpleMessageConverter.class);
		return response;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	

}
