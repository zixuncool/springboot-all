package com.rumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.bean.User;
import com.rumo.service.UserService;
import com.rumo.util.CodeMsg;
import com.rumo.util.Result;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	private UserService userService;
//	@Autowired
//	private OrderService orderService;
//	
//	@Autowired
//	MQSender sender;
//	
//	@RequestMapping("/mq/header")
//    @ResponseBody
//    public Result<String> header() {
//		sender.sendHeader("hello,imooc");
//        return Result.success("Hello，world");
//    }
//	
//	@RequestMapping("/mq/fanout")
//    @ResponseBody
//    public Result<String> fanout() {
//		sender.sendFanout("hello,imooc");
//        return Result.success("Hello，world");
//    }
	
//	@RequestMapping("/mq/topic")
//    @ResponseBody
//    public Result<String> topic() {
//		sender.sendTopic("hello,imooc");
//        return Result.success("Hello，world");
//    }
//	
//	@RequestMapping("/mq")
//    @ResponseBody
//    public Result<String> mq() {
//		sender.send("hello,imooc");
//        return Result.success("Hello，world");
//    }

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	// 1.rest api json输出 2.页面
	@RequestMapping("/hello")
	@ResponseBody
	public Result<String> hello() {
		return Result.success("hello,imooc");
		// return new Result(0, "success", "hello,imooc");
	}

	@RequestMapping("/helloError")
	@ResponseBody
	public Result<String> helloError() {
		return Result.error(CodeMsg.SERVER_ERROR);
	}

	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model) {
		model.addAttribute("name", "Joshua");
		return "hello";
	}

	@ResponseBody
	@RequestMapping("/getuser/{id}")
	public Result<User> getById(@PathVariable("id")Integer id){
		return userService.getUserByID(id);
	}
	
	/*@ResponseBody
	@RequestMapping("/getorder/{id}")
	public Result<Order> getById2(@PathVariable("id")String id){
		return orderService.getOrderByID(id);
	}*/
}
