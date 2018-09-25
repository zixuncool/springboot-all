package com.rumo.mapper;

import org.apache.ibatis.annotations.Param;

import com.rumo.bean.User;

public interface IUserMapper {

	
	public User getById(@Param("id")Integer id);
}
