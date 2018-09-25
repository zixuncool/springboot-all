package com.rumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.rabbitmq.topic.TopicSender;


@Controller
public class IndexController {

	@Autowired
	private TopicSender topicSender;

	
	@ResponseBody
	@GetMapping("/send")
	public String test() {
		topicSender.send();
		return "ok";
	}
}
