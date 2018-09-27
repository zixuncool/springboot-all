package com.rumo.service.role;

import com.rumo.vo.RoleVo;
import com.rumo.vo.ServerResponse;

public interface IRoleService {

	public ServerResponse findRoleByUserId(Integer userId);
	
	/**
	 * 查询所有角色
	 * 方法名：findRoles<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年9月27日-下午10:05:32 <br/>
	 * 手机:1564545646464<br/>
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse findRoles(int pageNo,int pageSize);

	/**
	 * 保存角色
	 * 方法名：saveRole<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年9月27日-下午8:21:50 <br/>
	 * 手机:1564545646464<br/>
	 * @param roleVo
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse saveRole(RoleVo roleVo);
	
	/**
	 * 根据id删除角色
	 * 方法名：deleteRole<br/>
	 * 创建人：mofeng <br/>
	 * 时间：2018年9月27日-下午10:01:39 <br/>
	 * 手机:1564545646464<br/>
	 * @param id
	 * @return ServerResponse<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public ServerResponse deleteRole(Integer id);
}
