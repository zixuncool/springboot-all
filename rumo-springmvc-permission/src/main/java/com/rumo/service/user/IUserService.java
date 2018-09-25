package com.rumo.service.user;

import com.github.pagehelper.PageInfo;
import com.rumo.params.UserVo;
import com.rumo.pojo.User;
import com.rumo.vo.ServerResponse;

public interface IUserService {

	public PageInfo<User> findUsers(int pageNum,int pageSize);
	
	public ServerResponse login(UserVo userVo);
}
