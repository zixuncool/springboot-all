
 /**
 * itbooking系统平台<br/>
 * com.rumo.service.role<br/>
 * RoleServiceImpl.java<br/>
 * 创建人:mofeng <br/>
 * 时间：2018年9月24日-下午9:34:24 <br/>
 * 2018itbooking-版权所有<br/>
 */
package com.rumo.service.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumo.mapper.RoleUserMapper;
import com.rumo.pojo.Role;
import com.rumo.vo.ServerResponse;

/**
 * 
 * RoleServiceImpl<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月24日-下午9:34:24 <br/>
 * @version 1.0.0<br/>
 * 
 */
@Service
public class RoleServiceImpl  implements IRoleService{

	
	@Autowired
	private RoleUserMapper roleUserMapper;
	
	@Override
	public ServerResponse findRoleByUserId(Integer userId) {
		List<Role> roles = roleUserMapper.findRoles(userId);
		return ServerResponse.createBySuccess(roles);
	}

}
