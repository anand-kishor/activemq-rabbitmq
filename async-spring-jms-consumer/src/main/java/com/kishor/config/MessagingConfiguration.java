package com.kishor.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.converter.SimpleMessageConverter;

import com.kishor.receiver.MessageReceiver;
@Configuration
public class MessagingConfiguration {
	
	private static final String  DEFAULT_BROKER_URL="tcp://localhost:61616";
	private static final String MESSAGE_QUEUE="kishor_queue";
	
	
	  @Autowired
	  MessageReceiver messageReceiver;
	 
	
	@Bean
	public ConnectionFactory connectionFactory()
	{
		ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory();
		
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		connectionFactory.setTrustedPackages(Arrays.asList("com.kishor"));
		return connectionFactory;
	}
	@Bean
	public MessageListenerContainer container()
	{
		DefaultMessageListenerContainer container=new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setDestinationName(MESSAGE_QUEUE);
		container.setMessageListener(messageReceiver);
		return container;
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
	MessageConverter converter()
	{
		return new SimpleMessageConverter();
	}

	

}
