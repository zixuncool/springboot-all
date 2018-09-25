package com.rumo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	//http://localhost:8089/index---web--distachservletConfigration--->--freemakerAutoConfiguration
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("title","Hello JSP!!!!");
		return "index";
	}
	
}
