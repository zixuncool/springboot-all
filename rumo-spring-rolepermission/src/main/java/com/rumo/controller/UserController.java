package com.rumo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.exception.PermissionException;
import com.rumo.service.user.IUserService;
import com.rumo.vo.ResponseCode;
import com.rumo.vo.ServerResponse;

@Controller
@RequestMapping("/user")
public class UserController {

	//日志
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	
	@ResponseBody
	@RequestMapping("/get/{username}")
	public String getuser(@PathVariable("username")String username) {
		
		if(username.length()<10) {
			throw new PermissionException(ResponseCode.ERROR);
		}
		
		return "你好，帅哥！！！";
	}
	
	@ResponseBody
	@RequestMapping("/find/{pageNo}/{pageSize}")
	public ServerResponse find(
			@PathVariable("pageNo")Integer pageNo,
			@PathVariable("pageSize")Integer pageSize
			) {
		
		log.info("查询用户信息!!!!");
		return userService.finServiceUsers(pageNo,pageSize);
	}
	
	
	
	
}
