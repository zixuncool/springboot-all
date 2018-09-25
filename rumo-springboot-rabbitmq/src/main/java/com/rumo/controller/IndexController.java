package com.rumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.rabbitmq.Producer;


@Controller
public class IndexController {

	@Autowired
	private Producer producer;

	
	@ResponseBody
	@GetMapping("/send")
	public String test() {
		producer.send();
		return "ok";
	}
}
