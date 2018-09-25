package com.rumo.service.user;

import com.rumo.params.UserVo;
import com.rumo.pojo.Params;
import com.rumo.vo.ServerResponse;

public interface IUserService {

	//public ServerResponse findUsers(int pageNum,int pageSize);
	
	public ServerResponse findUsers(Params params);
	
	public ServerResponse login(UserVo userVo);
}
