package com.rumo.service.user;

import com.rumo.vo.ServerResponse;

public interface IUserService {

	public ServerResponse finServiceUsers(int pageNo,int pageSize);
}
