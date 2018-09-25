package com.rumo.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.redis.RedisService;
import com.rumo.service.MiaoshaUserService;
import com.rumo.util.Result;
import com.rumo.vo.LoginVo;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	MiaoshaUserService  miaoshaUserService;
	
	@Autowired
	RedisService redisService;
	
    @RequestMapping
    public String toLogin() {
        return "login";
    }
    
    @RequestMapping("/logined")
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
    	log.info(loginVo.toString());
    	//登录
    	String token = miaoshaUserService.login(response, loginVo);
    	return Result.success(token);
    }
}
