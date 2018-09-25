package com.rumo.rabbitmq.route;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rumo.rabbitmq.ConnectionUtil;

/**
 * Created by mofeng on 2018/4/5/下午4:43
 */
public class Produer {
    private final static String EXCHANGE_NAME = "testeoute";

    public static void main(String[] args) throws  Exception{
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");//定义路由格式的交换机
        channel.basicPublish(EXCHANGE_NAME, "key1", null, "路由消息".getBytes());
        channel.close();
        connection.close();
    }
}
