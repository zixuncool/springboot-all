package com.rumo.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import com.mofeng.BlogService;
import com.mofeng.BlogServiceImpl;
import com.rumo.bean.Course;
import com.rumo.bean.User;


@SpringBootConfiguration//等价于： @Configuration
public class ApplicationContextConfiguration {
	
	//ApplicationContextConfiguration 配置是不会初始化到容器中，
	
	@Bean
	public User getUser() {
		User user = new User();
		user.setId(1);
		user.setUsername("墨风");
		return user;
	}
	
	
	@Bean
	public Course getCourse() {
		Course course = new Course();
		course.setTitle("Javascript是一门语言");
		return course;
	}
	
	
	@Bean
	public BlogService getBlogService() {
		return new BlogServiceImpl();
	}
}
