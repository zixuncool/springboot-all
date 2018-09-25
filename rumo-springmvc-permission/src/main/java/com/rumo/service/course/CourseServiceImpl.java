package com.rumo.service.course;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.mapper.CourseMapper;
import com.rumo.vo.CourseVo;
import com.rumo.pojo.Params;
import com.rumo.pojo.Course;
import com.rumo.vo.ServerResponse;


/**
 * 
 * 
 * CourseServiceImpl<br/>
 * 作者:墨风<br/>
 * 创建时间：2018年09月25日 23:31:35 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class CourseServiceImpl implements ICourseService  {

	@Autowired
	private CourseMapper courseMapper;
	
	public ServerResponse findCourses(Params params){
		PageHelper.startPage(params.getPageNo(), params.getPageSize());
		List<Course> courses = courseMapper.selectByPrimaryKeyAll(params);
		PageInfo<Course> pageInfo = new PageInfo<>(courses);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
}
