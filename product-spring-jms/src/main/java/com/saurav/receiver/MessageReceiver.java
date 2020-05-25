package com.saurav.receiver;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.saurav.model.Product;
@Component
public class MessageReceiver {
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	MessageConverter messageConverter;
	
	public Product receiveMessage() throws MessageConversionException, JMSException
	{
		Message message=jmsTemplate.receive();
		Product product=(Product)messageConverter.fromMessage(message);
		return product;
	}

}
