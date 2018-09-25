package com.rumo.service.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rumo.mapper.UserMapper;
import com.rumo.params.UserVo;
import com.rumo.pojo.User;
import com.rumo.service.role.IRoleService;
import com.rumo.util.MD5Util;
import com.rumo.vo.ServerResponse;

@Service
public class UserServiceImpl implements IUserService  {

	
	@Autowired
	private UserMapper userMapper;
	
	public PageInfo<User> findUsers(int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<User> users = userMapper.selectByPrimaryKeyAll();
		PageInfo<User> pageInfo = new PageInfo<>(users);
		return pageInfo;
	}
	
	
	@Override
	public ServerResponse login(UserVo userVo) {
		User user = userMapper.selectByPhone(userVo.getTelephone());
		if(user==null) {
			return ServerResponse.createByValidatorError("telephone","手机号码不存在!!");
		}
		
		if(!user.getPassword().equalsIgnoreCase(MD5Util.inputPassToDbPass(userVo.getPassword(),MD5Util.salt))) {
			return ServerResponse.createByValidatorError("password","密码不正确!!!");
		}
		
		//清空密码
		user.setPassword(null);
		return ServerResponse.createBySuccess(user);
	}
}
