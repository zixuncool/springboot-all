package com.rumo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.rumo.pojo.User;

//@Mapper
public interface UserMapper {
	
	@Select("select id ,username ,password FROM tb_user where id = #{id}")
	public User getById(@Param("id")Long id);
	

	@Select("select id ,username ,password FROM tb_user limit 0,10")
	public List<User> findUsers();
}
