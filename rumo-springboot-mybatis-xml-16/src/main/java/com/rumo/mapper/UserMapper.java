package com.rumo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.rumo.pojo.User;

public interface UserMapper {
	
	//xml
	public User getById(@Param("id")Long id);
	public List<User> findUsers();
	

	@Select("select id ,username ,password FROM tb_user limit 0,2")
	public List<User> findUsers2();
	
}
