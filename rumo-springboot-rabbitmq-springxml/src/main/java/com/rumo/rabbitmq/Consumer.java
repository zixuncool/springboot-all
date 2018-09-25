package com.rumo.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@RabbitHandler
	@RabbitListener(queues="rumo.queue")
	public void showMessage(String message) {
		System.out.println("接收到了消息是："+message);
	}
}
