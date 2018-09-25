package com.rumo.rabbitmq.publish;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rumo.rabbitmq.ConnectionUtil;

/**
 * Created by mofeng on 2018/4/5/下午4:33
 */
public class Recver1 {
    private final static String EXCHANGE_NAME = "testexchange";//定义交换机的名字

    public static void main(String[] args) throws Exception{

        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("testpubqueue1", false, false, false,null);
        //绑定队列到交换机
        channel.queueBind("testpubqueue1", EXCHANGE_NAME, "");

        channel.basicQos(1);
        DefaultConsumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者11111111:"+new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume("testpubqueue1", false, consumer);
    }
}
