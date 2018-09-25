package com.rumo.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rumo.pojo.User;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController implements InitializingBean{
	
	

	
	@RequestMapping("/index")
	public String index(User user, @ModelAttribute(value="sname")String sname,
			@ModelAttribute(value="params1")String params1,
			@ModelAttribute(value="params2")String params2) {
		System.out.println(sname);
		System.out.println(params1);
		System.out.println(params2);
		System.out.println(getUserId());
		System.out.println(getUserId2());
		System.out.println("index方法进来了"+user.getId());
		return "index";
	}
	
	@RequestMapping("/course")
	public String course(User user) {
		System.out.println(getUserId());
		System.out.println(getUserId2());
		System.out.println("course方法进来了"+user.getId());
		return "course";
	}
	
	@RequestMapping("/user")
	public String user(User user) {
		System.out.println("user方法进来了"+user.getId());
		return "user";
	}

	
	@Override
	public void afterPropertiesSet() throws Exception {
		//未来某一些针对页面，需要要把数据在启动的时候写入redis缓存获取其他得放，肯定需要此方法
		System.out.println("未来某一些针对页面，需要要把数据在启动的时候写入redis缓存获取其他得放，肯定需要此方法");
	}
}
