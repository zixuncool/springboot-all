package com.rumo.service.blog;

import com.rumo.vo.BlogVo;
import com.rumo.vo.ServerResponse;

public interface IBlogService {
	
	/**
	 * 
	 * (查询所有的内容博文模块)<br/>
	 * 方法名：queryBlogAll<br/>
	 * 创建人：中华墨风 <br/>
	 * 时间：2018年09月26日 21:46:48 <br/>
	 * 手机:1564545646464<br/>
	 * @param param
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse queryBlogAll(BlogVo blogVo);
	
	
}
