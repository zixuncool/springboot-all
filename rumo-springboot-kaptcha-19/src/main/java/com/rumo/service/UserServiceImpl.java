package com.rumo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.mapper.UserMapper;
import com.rumo.pojo.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public PageInfo<User> findUsers(Integer pageNo,Integer pageSize){
		//设置分页
		PageHelper.startPage(pageNo, pageSize);
		//查询所有用户-Mybatis 拦截所有的select方法
		List<User> users = userMapper.findUsers();
		//查询分页 
		PageInfo<User> pageInfo = new PageInfo<>(users); 
		return pageInfo;
	}

	@Override
	public User getById(Long id) {
		return userMapper.getById(id);
	}

	@Override
	public List<User> findUsers() {
		return userMapper.findUsers();
	}

	@Override
	public List<User> findUsers2() {
		return userMapper.findUsers2();
	}
}
