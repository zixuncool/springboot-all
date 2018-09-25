package com.rumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.bean.User;
import com.rumo.redis.RedisService;
import com.rumo.util.Result;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	RedisService redisService;
	
    @RequestMapping("/info")
    @ResponseBody
    public Result<User> getUserInfo(Model model,User user) {
        return Result.success(user);
    }
    
}
