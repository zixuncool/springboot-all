package com.rumo.controller.course;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.rumo.core.ApplicationContextHelper;
import com.rumo.pojo.Params;
import com.rumo.service.course.ICourseService;
import com.rumo.vo.ServerResponse;

@Controller
@RequestMapping("/admin/course")
public class CourseController {

	
	@Autowired
	private ICourseService courseService;
	
	
	@RequestMapping("/{path}")
	public String coursepath(@PathVariable("path")String path) {
		return "/admin/course/"+path;
	}
	
	/**
	 * todo:http://localhost:8082/admin/course/template/1/10
	 * 方法名：findCourses<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年9月25日-下午9:27:38 <br/>
	 * 手机:1564545646464<br/>
	 * @param pageNo
	 * @param pageSize
	 * @param modelMap
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@RequestMapping("/template")
	public String findCourses(Params params,ModelMap modelMap) {
		ServerResponse serverResponse = courseService.findCourses(params);
		//此serverResponse.getData()是一个@PageInfo<Course> getList对象
		modelMap.addAttribute("pages", serverResponse.getData());
		return "admin/course/template";
	}
	
	
}
