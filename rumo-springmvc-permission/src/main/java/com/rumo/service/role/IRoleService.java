package com.rumo.service.role;

import com.rumo.vo.ServerResponse;

public interface IRoleService {

	public ServerResponse findRoleByUserId(Integer userId);
	
}
