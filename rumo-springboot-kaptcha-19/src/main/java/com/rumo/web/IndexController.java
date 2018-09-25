package com.rumo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.rumo.pojo.User;
import com.rumo.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;

	//http://localhost:8089/index---web--distachservletConfigration--->--freemakerAutoConfiguration
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("title","Hello thymeleaf!!!!");
		return "index";
	}
	
	
	@ResponseBody
	@RequestMapping("/getuser/{id}")
	public User getuser(@PathVariable("id")Long id) {
		return userService.getById(id);
	}
	
	@ResponseBody
	@RequestMapping("/findUsers")
	public List<User> findUsers() {
		return userService.findUsers();
	}
	

	@ResponseBody
	@RequestMapping("/findUsers2")
	public List<User> findUsers2() {
		return userService.findUsers2();
	}
	
	

	@ResponseBody
	@RequestMapping("/findUsers3")
	public PageInfo<User> findUsers3() {
		return userService.findUsers(0,5);
	}
	
}
