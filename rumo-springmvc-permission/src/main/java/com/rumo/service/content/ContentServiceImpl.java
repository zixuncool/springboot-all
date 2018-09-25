package com.rumo.service.content;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.mapper.ContentMapper;
import com.rumo.vo.ContentVo;
import com.rumo.pojo.Params;
import com.rumo.pojo.Content;
import com.rumo.vo.ServerResponse;

/**
 * 
 * 
 * ContentServiceImpl<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月25日-下午11:27:25 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class ContentServiceImpl implements IContentService  {

	@Autowired
	private ContentMapper contentMapper;
	

	public ServerResponse findContents(Params params){
		PageHelper.startPage(params.getPageNo(), params.getPageSize());
		List<Content> contents = contentMapper.selectByPrimaryKeyAll(params);
		PageInfo<Content> pageInfo = new PageInfo<>(contents);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
}
