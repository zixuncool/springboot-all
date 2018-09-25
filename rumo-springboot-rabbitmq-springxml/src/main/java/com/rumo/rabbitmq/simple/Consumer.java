package com.rumo.rabbitmq.simple;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rumo.rabbitmq.ConnectionUtil;

/**
 *  定义消费者
 * @author mengk
 *
 */
public class Consumer {

	
	public static final String QUEUE_NAME = "rumo.queue.test";
	
	/**
	 * 接收消息方法
	 */
	public static void revericeMessage() {
		try {
			//获取链接和MQ的通道信息
			Connection connection = ConnectionUtil.getConnection();
			//创建消息通道
			Channel channel = connection.createChannel();
			
			//申明消息队列
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			
			//定义消费者
			DefaultConsumer consumer = new DefaultConsumer(channel) {
	            @Override
	            public void handleDelivery(String consumerTag, Envelope envelope,
	                                       AMQP.BasicProperties properties, byte[] body)
	                    throws IOException {
	                String message = new String(body, "UTF-8");
	                System.out.println("Customer Received '" + message + "'");
	            }
	        };
			
			//接收消息 true代表：自动确认消息
			channel.basicConsume(QUEUE_NAME, true,consumer);
			
			//channel.close();
			//connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		revericeMessage();
	}
	
}
