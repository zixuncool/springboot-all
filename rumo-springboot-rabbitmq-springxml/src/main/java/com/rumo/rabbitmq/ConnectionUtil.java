package com.rumo.rabbitmq;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 定义链接工厂类
 * @author mengk
 *
 */
public class ConnectionUtil {

	
	public  static Connection getConnection() throws IOException, TimeoutException {
		//创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务器地址
        factory.setHost("47.104.109.215");
        //设置账号和密码
        factory.setUsername("admin");
        factory.setPassword("mkxiaoer");
        //设置端口号
        factory.setPort(5672);
        //设置范文的虚拟主机目录,默认是根 /
        factory.setVirtualHost("/rumo");
        //创建一个新的连接
        Connection connection = factory.newConnection();
        //返回链接
        return connection;
	}
	
	public static void main(String[] args) throws IOException, TimeoutException {
		System.out.println(getConnection());
	}

}