package com.rumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mofeng.BlogService;
import com.rumo.bean.Course;
import com.rumo.bean.User;

@RestController
public class IndexController {

	
	
	@Autowired
	private User user;
	@Autowired
	private Course course;
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/index")
	public String index() {
		return user.getId()+"=="+user.getUsername() + course.getTitle()+"=="+blogService.sayHello();
		
	}
}
