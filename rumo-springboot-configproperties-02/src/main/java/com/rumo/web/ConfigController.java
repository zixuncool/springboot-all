package com.rumo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.config.RumoProperties;



@Controller
public class ConfigController {


	@Value("${rumo.name}")
	private String name;
	@Value("${rumo.address}")
	private String address;
	
	@Autowired
	private RumoProperties rumoProperties;
	
	
	@ResponseBody
	@RequestMapping("/show")
	public String show() {
		return name + " : "+ address;
	}
	
	
	@ResponseBody
	@RequestMapping("/show2")
	public String show2() {
		return rumoProperties.getName() + " : "+ rumoProperties.getAddress();
	}

}
