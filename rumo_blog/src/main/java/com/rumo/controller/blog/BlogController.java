package com.rumo.controller.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.service.blog.IBlogService;
import com.rumo.vo.BlogVo;
import com.rumo.vo.ServerResponse;

/**
 * 
 * todo:内容博文模块Controller控制器类
 * BlogController<br/>
 * 作者:中华墨风<br/>
 * 创建时间：2018年09月26日 21:46:48 <br/>
 * @version 1.0.0<br/>
 *
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	private IBlogService blogService;
	
	
	@ResponseBody
	@RequestMapping("/findblogs")
	public ServerResponse findBlogs(BlogVo blogVo) {
		return blogService.queryBlogAll(blogVo);
	}
	
}
