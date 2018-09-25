package com.rumo.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.mapper.UserMapper;
import com.rumo.pojo.User;
import com.rumo.vo.ServerResponse;

@Service
public class UserServiceImpl implements IUserService {

	

	@Value("${db.driverClassName}")
	private String drivername;
	
	
	@Autowired
	public UserMapper userMapper;
	
	@Override
	public ServerResponse finServiceUsers(int pageNo,int pageSize) {
		System.out.println("==============>"+drivername);
		//定义分页拦截器---动态代理
		PageHelper.startPage(pageNo, pageSize);
		//查询用户信息 
		List<User> users = userMapper.findUsers();
		//把查询的用户信息和分页信息一并返回
		PageInfo<User> pageInfo = new PageInfo<>(users);
		return ServerResponse.createBySuccess(pageInfo);
	}

}
