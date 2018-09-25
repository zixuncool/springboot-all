package com.rumo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.rumo.core.ApplicationContextHelper;
import com.rumo.pojo.User;
import com.rumo.service.user.IUserService;

@Controller
public class UserController {

	
	/*@Autowired
	private IUserService userService;*/
	
	@ResponseBody
	@RequestMapping("/findUsers/{pageNo}/{pageSize}")
	public PageInfo<User> findUsers(@PathVariable("pageNo")Integer pageNo,@PathVariable("pageSize")Integer pageSize) {
		IUserService userService = ApplicationContextHelper.popBean(IUserService.class);
		return userService.findUsers(pageNo, pageSize);
	}
	
	
}
