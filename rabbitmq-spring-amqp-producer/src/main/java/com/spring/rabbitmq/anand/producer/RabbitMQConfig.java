package com.spring.rabbitmq.anand.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import com.rabbitmq.client.AMQP.Queue;

@Configuration
@EnableAutoConfiguration
public class RabbitMQConfig {
	final static String queue_name="message_queue";
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Bean
	public ConnectionFactory connectionFactory()
	{
		CachingConnectionFactory connectionFactory=new CachingConnectionFactory("localhost");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		return connectionFactory;
		
	}
	@Bean
	Queue queue()
	{
		return new Queue(queue_name,false);
	}
	@Bean
	TopicExchange exchange()
	{
		return new TopicExchange("message_queue_exchange");
	}
	@Bean
	Binding binding(Queue queue,TopicExchange exchange)
	{
		return BindingBuilder.bind(queue).to(exchange).with(queue_name);
	}
	
	

}
