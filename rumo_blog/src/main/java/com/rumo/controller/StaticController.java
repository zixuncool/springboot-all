/*
 *//**
 * itbooking系统平台<br/>
 * com.rumo.controller<br/>
 * StaticController.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年10月6日-下午4:40:09 <br/>
 * 2018itbooking-版权所有<br/>
 *//*
package com.rumo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumo.config.StaticFreemakerUtil;

*//**
 * 
 * StaticController<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年10月6日-下午4:40:09 <br/>
 * @version 1.0.0<br/>
 * 
 *//*
@RestController
public class StaticController {

	@Autowired
	private StaticFreemakerUtil freemakerUtil;
	
	@RequestMapping("/static/index")
	public String staticindex(HttpServletRequest request) {
		return freemakerUtil.index(request);
	}
	
	@RequestMapping("/static/blogid")
	public String staticblogid(HttpServletRequest request) {
		return freemakerUtil.blogid(request);
	}
	
	@RequestMapping("/static/courseid")
	public String staticcourseid(HttpServletRequest request) {
		return freemakerUtil.courseid(request);
	}
	
	@RequestMapping("/static/playid")
	public String staticplayid(HttpServletRequest request) {
		return freemakerUtil.playid(request);
	}
	
	@RequestMapping("/static/blog")
	public String staticblog(HttpServletRequest request) {
		return freemakerUtil.blog(request);
	}
	
	@RequestMapping("/static/course")
	public String staticcourse(HttpServletRequest request) {
		return freemakerUtil.course(request);
	}
	
	@RequestMapping("/static/play")
	public String staticplay(HttpServletRequest request) {
		return freemakerUtil.play(request);
	}
}
*/