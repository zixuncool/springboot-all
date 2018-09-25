package com.rumo.service.stat;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.mapper.StatMapper;
import com.rumo.vo.StatVo;
import com.rumo.pojo.Params;
import com.rumo.pojo.Stat;
import com.rumo.vo.ServerResponse;


/**
 * 
 * todo:统计管理模块
 * StatServiceImpl<br/>
 * 作者:笑对人生<br/>
 * 创建时间：2018年09月25日 23:32:42 <br/>
 * @version 1.0.0<br/>
 *
 */
@Service
public class StatServiceImpl implements IStatService  {

	@Autowired
	private StatMapper statMapper;
	
	public ServerResponse findStats(Params params){
		PageHelper.startPage(params.getPageNo(), params.getPageSize());
		List<Stat> stats = statMapper.selectByPrimaryKeyAll(params);
		PageInfo<Stat> pageInfo = new PageInfo<>(stats);
		return ServerResponse.createBySuccess(pageInfo);
	}
	
}
