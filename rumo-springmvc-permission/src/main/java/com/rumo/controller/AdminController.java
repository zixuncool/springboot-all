package com.rumo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@RequestMapping("/{path}")
	public String index(@PathVariable("path")String path) {
		return "admin/"+path;
	}
	
}
