package com.rumo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.bean.User;
import com.rumo.redis.RedisService;
import com.rumo.redis.UserKey;
import com.rumo.util.Result;

@Controller
@RequestMapping
public class RedisController {
	
	@Autowired
	RedisService redisService;


    
    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
    	User  user  = redisService.get(UserKey.getById, ""+1, User.class);
        return Result.success(user);
    }
    
    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
    	User user  = new User();
    	user.setId(1l);
    	user.setUsername("1111");
    	redisService.set(UserKey.getById, ""+1, user);
        return Result.success(true);
    }
    
    
}
