/**
 * TODO濡沫系统平台<br/>
 * com.rumo.service.permission<br/>
 * PermissionServerImpl.java<br/>
 *  创建人:mofeng <br/>
 * 时间：2018年9月20日-下午3:59:08 <br/>
 * 2018濡沫公司-版权所有<br/>
 */
package com.rumo.service.permission;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumo.core.RequestHolder;
import com.rumo.mapper.RolePermissionMapper;
import com.rumo.pojo.Permission;
import com.rumo.vo.ServerResponse;

/**
 * 
 * PermissionServerImpl<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月20日-下午3:59:08 <br/>
 * @version 1.0.0<br/>
 * 
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

	
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	@Override
	public ServerResponse save(Permission permission) {
		System.out.println(RequestHolder.getCurrentUser().getId());
		return ServerResponse.createBySuccess();
	}
	
	
	@Override
	public ServerResponse findRoleUserPersmission(Integer userId) {
		java.util.List<Map<String,String>> permissions = rolePermissionMapper.findByRoleUserPermission(userId);
		return ServerResponse.createBySuccess(permissions);
	}

}
