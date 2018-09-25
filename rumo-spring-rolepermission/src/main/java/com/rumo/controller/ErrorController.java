package com.rumo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
	
	@RequestMapping("/error/500")
	public String error500() {
		return "error500";
	}
}
