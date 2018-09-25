package com.rumo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.mapper.UserMapper;
import com.rumo.pojo.User;

@Controller
public class IndexController {
	
	@Autowired
	private UserMapper userMapper;

	//http://localhost:8089/index---web--distachservletConfigration--->--freemakerAutoConfiguration
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("title","Hello thymeleaf!!!!");
		return "index";
	}
	
	
	@ResponseBody
	@RequestMapping("/getuser/{id}")
	public User getuser(@PathVariable("id")Long id) {
		return userMapper.getById(id);
	}
	
	@ResponseBody
	@RequestMapping("/findUsers")
	public List<User> findUsers() {
		return userMapper.findUsers();
	}
}
