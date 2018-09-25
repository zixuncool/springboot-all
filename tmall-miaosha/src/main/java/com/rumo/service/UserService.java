package com.rumo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumo.bean.User;
import com.rumo.mapper.IUserMapper;
import com.rumo.util.Result;

@Service
public class UserService {

	@Autowired
	private IUserMapper userMapper;
	
	
	public Result<User> getUserByID(Integer id){
		User user = userMapper.getById(id);
		return Result.success(user);
	}
}
