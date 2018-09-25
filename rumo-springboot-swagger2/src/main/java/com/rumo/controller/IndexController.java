
 /**
 * itbooking系统平台<br/>
 * com.rumo.controller<br/>
 * IndexController.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月24日-下午8:21:51 <br/>
 * 2018itbooking-版权所有<br/>
 */
package com.rumo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.pojo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * IndexController<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月24日-下午8:21:51 <br/>
 * @version 1.0.0<br/>
 * 
 */
@Controller
@RequestMapping
@Api("首页管理")
public class IndexController {

	
	//@RequestMapping 以上
	@ApiOperation(value="访问首页",notes="我和你讲一个故事，这是一个首页")
	//@RequestMapping(value="/index",method=RequestMethod.GET)
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	

	@ResponseBody
	@PostMapping("/save")
	@ApiOperation(value="注册用户",notes="我和你讲一个故事，这注册用户")
	//@ApiImplicitParam(name="user",value="用户实体对象",required=true,dataType="User")
	@ApiImplicitParams(value= {
		@ApiImplicitParam(name="user",value="用户实体对象",required=true,dataType="User"),
		@ApiImplicitParam(name="id",value="用户id",required=true,dataType="int")
	})
	public String save(User user,int id) {
		return "success=1111111";
	}
	
	
	
	
	
	@ResponseBody
	@GetMapping("/getUser/{id}")
	@ApiOperation(value="获取某个用户信息",notes="我和你讲一个故事，根据id获取用户信息")
	@ApiImplicitParam(name="id",value="用户id",required=true,dataType="int",paramType="path")
	public String getUser(@ApiParam(name="id",required=true,value="用户id是一个必填字段") @PathVariable("id")int id) {
		return "success---ok";
	}
	
	
	
}
