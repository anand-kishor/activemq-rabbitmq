package com.kishor.receiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.kishor.model.Product;
@Component
public class MessageReceiver implements MessageListener {
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	MessageConverter messageConverter;

	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			Product product=(Product)messageConverter.fromMessage(message);
			System.out.println("..........inside on message............");
			System.out.println(product);
			System.out.println("..........inside on message............");
		} catch (MessageConversionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
