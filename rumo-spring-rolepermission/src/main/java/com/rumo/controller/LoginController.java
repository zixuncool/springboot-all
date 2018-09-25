package com.rumo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	
	@Value("${ip}")
	private String ip;
	@Value("${imgpath}")
	private String imgpath;
	
	//日志
	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/login")
	public String login() {
		log.info("登录进来了.....,{},{},{}",ip,imgpath);
		return "login";
	}
}
