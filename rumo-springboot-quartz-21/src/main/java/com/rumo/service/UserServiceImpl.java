package com.rumo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements IUserService{

	
	/**
	 * 查询用户方法
	 */
	public String sayHello() {
		return "你好，mofeng,当前时间是："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	
	
}

