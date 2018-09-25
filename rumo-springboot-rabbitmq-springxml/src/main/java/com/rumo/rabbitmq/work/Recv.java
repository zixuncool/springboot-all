package com.rumo.rabbitmq.work;

import java.io.IOException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rumo.rabbitmq.ConnectionUtil;

public class Recv {

    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 同一时刻服务器只会发一条消息给消费者,告诉服务器，在我们没有确认当前消息完成之前，不要给我发新的消息，
        //相当于让步操作，因为多个消费者同时在竞争，加了以后就看谁和服务器响应最快，响应最快的就获取执行的消息数量就会多一些。
        channel.basicQos(1);
        
        System.out.println("消费者recv启动了.....");

        // 定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				 String message = new String(body, "UTF-8");
	             System.out.println("Customer Received '" + message + "'");
	             try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	             //确认 false为确认收到消息，true代表是拒绝收到消息.
	            channel.basicAck(envelope.getDeliveryTag(), false);
	             
			}
        	
        };
        // 注册消费者，监听队列，参数2：手动确认，代表我们接收到参数后告诉服务器，我们收到消息了。
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}