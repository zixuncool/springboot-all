package com.rumo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapper {
   
	
	/**
	 * 查询用户对应的所有角色对应的权限
	 * 方法名：findByRoleUserPermission<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年9月24日-下午10:00:01 <br/>
	 * 手机:1564545646464<br/>
	 * @return Map<String,Object><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public List<Map<String, String>> findByRoleUserPermission(@Param("uid")Integer userId); 
}