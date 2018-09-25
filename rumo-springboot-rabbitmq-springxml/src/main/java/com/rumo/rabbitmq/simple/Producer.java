package com.rumo.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rumo.rabbitmq.ConnectionUtil;

/**
 *  定义生产者
 * @author mengk
 *
 */
public class Producer {

	
	public static final String QUEUE_NAME = "rumo.queue.test";
	
	/**
	 * 发送消息方法
	 */
	public static void sendMessage() {
		try {
			//获取链接和MQ的通道信息
			Connection connection = ConnectionUtil.getConnection();
			//创建消息通道
			Channel channel = connection.createChannel();
			
			//申明消息队列
			/*   queueDeclare
				 第一个参数表示队列名称、
				 第二个参数为是否持久化（true表示是，队列将在服务器重启时生存）、
				 第三个参数为是否是独占队列（创建者可以使用的私有队列，断开后自动删除）、
				 第四个参数为当所有消费者客户端连接断开时是否自动删除队列、
				 第五个参数为队列的其他参数
			 */
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			
			//发送消息
			String message = "hello world!";
			//参数1：交换机  参数2：发送到那个队列 参数3：配置属性 参数4：发送的内容
			//basicPublish第一个参数为交换机名称、第二个参数为队列映射的路由key、第三个参数为消息的其他属性、第四个参数为发送信息的主体
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println("发送的内容是："+message);
			//关闭
			channel.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		sendMessage();
	}
	
}
