package com.rumo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.service.UserService;



@Controller
public class IndexController {

	@Autowired
	private UserService userService;//A不能 B能
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return userService.sayHello();
	}

}
