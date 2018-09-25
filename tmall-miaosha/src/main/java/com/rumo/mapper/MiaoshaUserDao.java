package com.rumo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rumo.bean.User;


@Mapper
public interface MiaoshaUserDao {
	
	@Select("select * from tb_user where id = #{id}")
	public User getById(@Param("id")long id);

	@Update("update tb_user set password = #{password} where id = #{id}")
	public void update(User toBeUpdate);
}
