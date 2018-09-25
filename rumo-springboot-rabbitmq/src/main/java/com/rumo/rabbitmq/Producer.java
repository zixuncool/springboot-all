package com.rumo.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	
	public void send() {
		amqpTemplate.convertAndSend("rumo.queue", "你好!");
	}
	
	
}
