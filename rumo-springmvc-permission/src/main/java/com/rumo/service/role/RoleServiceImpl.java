
 /**
 * itbooking系统平台<br/>
 * com.rumo.service.role<br/>
 * RoleServiceImpl.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月24日-下午9:34:24 <br/>
 * 2018itbooking-版权所有<br/>
 */
package com.rumo.service.role;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.mapper.RoleMapper;
import com.rumo.mapper.RoleUserMapper;
import com.rumo.pojo.Role;
import com.rumo.util.IpUtil;
import com.rumo.vo.RequestThrealLocalUtil;
import com.rumo.vo.RoleVo;
import com.rumo.vo.ServerResponse;

/**
 * 
 * RoleServiceImpl<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月24日-下午9:34:24 <br/>
 * @version 1.0.0<br/>
 * 
 */
@Service
public class RoleServiceImpl  implements IRoleService{

	private static Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private RoleUserMapper roleUserMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public ServerResponse findRoles(int pageNo,int pageSize) {
		//1:"设置分页条件
		PageHelper.startPage(pageNo, pageSize);
		//2:查询角色
		List<Role> roles = roleMapper.selectRoles();
		//3:设置查询分页信息，和求总数
		PageInfo<Role> pageInfo = new PageInfo<>(roles);
		//注意代码的顺序不能随意颠倒
		//返回 
		return ServerResponse.createBySuccess(pageInfo);
	}
	
	
	@Override
	public ServerResponse findRoleByUserId(Integer userId) {
		List<Role> roles = roleUserMapper.findRoles(userId);
		return ServerResponse.createBySuccess(roles);
	}
	
	@Override
	public ServerResponse saveRole(RoleVo roleVo) {
		
		//strurt2---多线程的所有请求管理---ThrealLocal进行存储的
		//struts2 会很多拦截器栈---数据间传递--20-40个---如何拦截器和拦截器数据传递和通讯---
		//HiberanteSessionFactoryUtil.java--ThreadLocal-存储session为什么?
		
		//从本地线程中获取
		String username = RequestThrealLocalUtil.getUser().getUsername();
		Integer userId = RequestThrealLocalUtil.getUser().getId();
		String ipString = IpUtil.getUserIP(RequestThrealLocalUtil.getCurrentRequest());
		
		log.info("当前从线程副本中获取的用户名是：{},用户的ID是：{}",username,userId);
		
		
		Role role = new Role();
		
		//拷贝保证属性相同和类型相同即可，就拷贝
		//BeanUtils.copyProperties(roleVo, role);
		
		role.setName(roleVo.getName());
		role.setStatus(roleVo.getStatus());
		role.setRemark(roleVo.getRemark());
		
		role.setOperateIp(ipString);
		role.setOperator(username);
		role.setType(1);
		int count = roleMapper.insert(role);
		log.info("保存角色成功，角色id是：{}",role.getId());
		return count >0?ServerResponse.createBySuccess():ServerResponse.createByError();
	}


	@Override
	public ServerResponse deleteRole(Integer id) {
		int count = roleMapper.deleteByPrimaryKey(id);
		return count >0?ServerResponse.createBySuccess():ServerResponse.createByError();
	}

}
