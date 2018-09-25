package com.rumo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rumo.pojo.Role;

public interface RoleUserMapper {
   
	
	 /**
     * 查询用户对应的角色
     * 方法名：findRoles<br/>
     * 创建人：mofeng <br/>
     * 时间：2018年9月24日-下午9:27:26 <br/>
     * 手机:1564545646464<br/>
     * @param userId
     * @return List<Role><br/>
     * @exception <br/>
     * @since  1.0.0<br/>
     */
    List<Role> findRoles(@Param("uid")Integer userId);
    
    
}