package com.rumo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rumo.pojo.User;
import com.rumo.rabbitmq.object.ObjectSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {

	@Autowired
	private ObjectSender sender;

	@Test
	public void sendOject() throws Exception {
		User user=new User();
		user.setUsername("mofeng");
		user.setPassword("123456");
		sender.send(user);
	}

}