package com.rumo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/standardData")
	public String standardData() {
		return "standardData";
	}
}
