package com.rumo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogbackController {

	//private  Logger log = LoggerFactory.getLogger(LogbackController.class); 
	private  Logger log = LoggerFactory.getLogger(this.getClass());; 
	
	@RequestMapping("/log")
	public String index(String name) {
		/*log.trace("trace 日志输出了....");
		log.debug("debug 日志输出了....");
		log.info("info 日志输出了...."); 
		log.warn("warn 日志输出了....");
		log.error("error 日志输出了....");*/
		log.info("你好{},我的参数值是：{},当前加载的类名：{}", "mofeng","湖南长沙",this.getClass().getName());
		return "index";
	}
	
}
