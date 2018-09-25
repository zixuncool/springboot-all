package com.mofeng;

import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

	public String sayHello() {
		return "你好我是一个大帅哥!!!";
	}
}
