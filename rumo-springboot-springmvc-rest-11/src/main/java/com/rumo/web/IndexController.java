package com.rumo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("title","Hello Freemaker!!!!");
		return "index";
	}
	
}
