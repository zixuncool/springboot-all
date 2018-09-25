package com.rumo.web;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rumo.service.EmailService;

@RestController
public class EmailController {
	
	
	@Autowired
	private EmailService emailService;
	
	
	@GetMapping("/sendmail")
	@ResponseBody
	public String sendmail() {
		emailService.sendEmail("3013229864@qq.com", "濡沫教育", "欢迎加入濡沫大家庭!!!");
		return "success";
	}
	
	@GetMapping("/sendmail2")
	@ResponseBody 
	public String sendmail2() {
		emailService.sendAttachmentEmail("3013229864@qq.com", "濡沫教育", "欢迎加入濡沫大家庭!!!附件发送",new File("src/main/resources/banner.txt"));
		return "success";
	}
	
	@GetMapping("/sendmail3")
	@ResponseBody
	public String sendmail3() {
		emailService.sendTemplateEmail("3013229864@qq.com", "濡沫教育", "template.html");
		return "success";
	}
}
