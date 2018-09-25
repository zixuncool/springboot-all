
 /**
 * itbooking系统平台<br/>
 * com.rumo.controller<br/>
 * CourseController.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月25日-下午8:15:38 <br/>
 * 2018itbooking-版权所有<br/>
 */
package com.rumo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.pojo.Course;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * CourseController<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月25日-下午8:15:38 <br/>
 * @version 1.0.0<br/>
 * 
 */
@Controller
@Api("课程管理")
//@CrossOrigin(origins = {"http://127.0.0.1:8848"})
public class CourseController {

	
	
	@ResponseBody
	@ApiOperation(value="查询课程",notes="课程查询，每页显示10条")
	@GetMapping("/cors/findCourse")
	//打开允许外界的访问
	//@CrossOrigin(origins = "*")
	public List<Course> findCourse(){
		
		List<Course> courses = new ArrayList<>();
		Course course = new Course();
		course.setId(1);
		course.setTitle("java是一个语言");
		course.setPrice(1258f);
		course.setCreateTime(new Date());
		course.setContent("java");
		courses.add(course);
		
		course = new Course();
		course.setId(2);
		course.setTitle("javascript是一个语言");
		course.setPrice(125f);
		course.setCreateTime(new Date());
		course.setContent("js");
		courses.add(course);
		return courses;
	}
	
	
	@ResponseBody
	@ApiOperation(value="查询课程",notes="课程查询，每页显示10条")
	@GetMapping("/findCourse2")
	public List<Course> findCourse2(){
		
		List<Course> courses = new ArrayList<>();
		Course course = new Course();
		course.setId(1);
		course.setTitle("java是一个语言");
		course.setPrice(1258f);
		course.setCreateTime(new Date());
		course.setContent("java");
		courses.add(course);
		
		course = new Course();
		course.setId(2);
		course.setTitle("javascript是一个语言");
		course.setPrice(125f);
		course.setCreateTime(new Date());
		course.setContent("js");
		courses.add(course);
		return courses;
	}
	
	
}
