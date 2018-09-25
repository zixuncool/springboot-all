package com.rumo.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.pojo.UserVo;

@Controller
public class ValiatorLoginController {

	@ResponseBody
	@GetMapping("/vlogined")
	public UserVo  vlogined(@Valid UserVo user) {
		/*
		 * user.setId(100); user.setUsername("mofeng"); user.setBirthday(new Date());
		 * user.setAge(32);
		 */
		return user;
	}

}
