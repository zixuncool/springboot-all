package com.rumo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.rumo.pojo.User;

public interface UserService {

	public PageInfo<User> findUsers(Integer pageNo,Integer pageSize);
	public User getById(@Param("id")Long id);
	public List<User> findUsers();
	public List<User> findUsers2();
}
