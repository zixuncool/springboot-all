package com.rumo.rabbitmq.topic;

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
    private final static String EXCHANGE_NAME = "testtopic";//定义交换机的名字

    public static void main(String[] args) throws Exception{
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("testtopicqueue1", false, false, false,null);
        //绑定队列到交换机
        //参数3 标记,绑定到交换机的时候会指定一个标记,只有和它一样的标记的消息才会被当前消费者收到
        channel.queueBind("testtopicqueue1", EXCHANGE_NAME, "key.*");
        //如果要接收多个标记,只需要再执行一次即可
        channel.queueBind("testtopicqueue1", EXCHANGE_NAME, "abc.#");
        channel.basicQos(1);
        DefaultConsumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者11111111:"+new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume("testtopicqueue1", false, consumer);
    }
}
