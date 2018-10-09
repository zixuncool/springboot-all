package com.rumo.service.blog;


import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.config.RequestThrealLocal;
import com.rumo.mapper.BlogMapper;
import com.rumo.pojo.Blog;
import com.rumo.vo.BlogVo;
import com.rumo.vo.ServerResponse;


/**
 * 
 * todo:内容博文模块Service实现类
 * BlogServiceImpl<br/>
 * 作者:中华墨风<br/>
 * 创建时间：2018年09月26日 21:46:48 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class BlogServiceImpl implements IBlogService  {

	@Autowired
	private BlogMapper blogMapper;
	
	public ServerResponse queryBlogAll(BlogVo blogVo){
		PageHelper.startPage(blogVo.getPageNo(), blogVo.getPageSize());
		blogVo.setSort(" c.create_time desc ");
		List<Map<String,Object>> blogs = blogMapper.queryBlogMapAll(blogVo);
		PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(blogs);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
}
