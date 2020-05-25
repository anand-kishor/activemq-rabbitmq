package com.kishor.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.messaging.converter.SimpleMessageConverter;




@Configuration
public class MessagingConfiguration<MessageReceiver> {
	private static final String  DEFAULT_BROKER_URL="tcp://localhost:61616";
	private static final String MESSAGE_QUEUE="kishor_queue";
	
	
	
	 @Autowired MessageReceiver messageReceiver;
	
	
	@Bean
	public ConnectionFactory connectionFactory()
	{
		ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory();
		
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		connectionFactory.setTrustedPackages(Arrays.asList("com.kishor"));
		return connectionFactory;
	}
	@Bean
	public JmsTemplate jmsTemplate()
	{
		JmsTemplate jmsTemplate=new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		jmsTemplate.setDefaultDestinationName(MESSAGE_QUEUE);
		return jmsTemplate;
	}
	@Bean
	SimpleMessageConverter converter()
	{
		return new SimpleMessageConverter();
	}

}
